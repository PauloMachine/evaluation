using System;
using System.Windows.Forms;
using System.ServiceProcess;
using Microsoft.Win32;
using System.Security.Principal;
using System.Diagnostics;
using System.Reflection;
using System.Xml;
using System.IO;

namespace MonitorPortalBusinessIntelligence
{
    public partial class Form1 : Form
    {
        public Form1()
        {
             InitializeComponent();
             listaServicos();
        }

        //Declaração de variaveis
        string nomeDefault = "PF_PortalBusinessIntelligence_";
        string nomeServico = "";
        string ipServico = "";
        string bancoServico = "";
        string portaServico = "";

        //Pega sempre a pasta atual dos arquivos
        String pathServico = System.Environment.CurrentDirectory;

        //Responsável por atualizar a lista de serviço em caso de travamento
        private void btnRefresh_Click(object sender, EventArgs e)
        {
            listaServicos();
        }

        private void listaServicos ()
        {
            //Declarando a classe ServiceController e preenchendo um array com todos os serviços 
            //do windows usando o método GetServices()
            ServiceController[] services = ServiceController.GetServices();

            //Criando o cabeçalho com o nome das colunas no ListView
            MontaColunasListView();

            //Limpa lista
            lvServicos.Items.Clear();
            lvServicos.Refresh();

            //Percorre a relação de serviços e exibe no listview
            foreach (ServiceController service in services)
            {
                try
                {
                    string filterDescricao = Registry.LocalMachine.OpenSubKey("SYSTEM\\CurrentControlSet\\services\\" + service.ServiceName).GetValue("Description").ToString();

                    //filtro de descrição
                    if ((filterDescricao != null) && (filterDescricao == "Serviço do Portal Business Intelligence da Precisa Fábrica de Software"))
                    {

                        //cria instância do ListViewIte
                        ListViewItem novoListViewItem = new ListViewItem();


                        //obtendo nome 
                        novoListViewItem.Text = service.ServiceName.ToString();


                        //tratamento do status do serviço
                        if (service.Status.ToString() == "Running")
                        {
                            novoListViewItem.SubItems.Add("Em execução");
                        } else 
                        {
                            novoListViewItem.SubItems.Add("Parado");
                        }

                        //obtendo detalhes do serviço
                        RegistryKey regKey1 = Registry.LocalMachine.OpenSubKey("SYSTEM\\CurrentControlSet\\services\\" + service.ServiceName);
                        novoListViewItem.SubItems.Add(regKey1.GetValue("ImagePath").ToString());

                        //novoListViewItem.SubItems.Add(Registry.LocalMachine.OpenSubKey("SYSTEM\\CurrentControlSet\\services\\" + service.ServiceName).GetValue("Location").ToString());

                        //novoListViewItem.SubItems.Add(regKey1.GetValue("Location").ToString());
                        regKey1.Close();

                        //exibindo as informações
                        lvServicos.Items.Add(novoListViewItem);
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
            }
        }

        //Monta Coluna no ListView
        private void MontaColunasListView()
        {
            lvServicos.Columns.Add("Nome", 250, HorizontalAlignment.Left);
            lvServicos.Columns.Add("Status", 100, HorizontalAlignment.Left);
            lvServicos.Columns.Add("Localização", 500, HorizontalAlignment.Left);
        }

        // Monta o array de serviços
        private void lvServicos_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                nomeServico = lvServicos.SelectedItems[0].SubItems[0].Text;
                lvServicos.Refresh();
            }
            catch
            {
                nomeServico = "";
                lvServicos.Refresh();
            }
        }

        //Reponsável por parar o serviço
        private void btnPararServico_Click(object sender, EventArgs e)
        {

            if (string.IsNullOrEmpty(nomeServico))
            {
                MessageBox.Show("Selecione o serviço!", "Servico", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                try
                {
                    DialogResult resultado = MessageBox.Show("Deseja parar o serviço : " + nomeServico + " ?", "Parar", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

                    if (resultado == DialogResult.Yes)
                    {
                        ServicosWin.ServicosWin.StopService(nomeServico);
                        listaServicos();
                        MessageBox.Show("Serviço parado!");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Erro : " + ex.Message + Environment.NewLine + ex.InnerException, "Parar Serviço", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        // Reponsável por iniciar o serviço
        private void btnIniciar_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(nomeServico))
            {
                MessageBox.Show("Selecione o serviço!", "Servico", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                try
                {
                    DialogResult resultado = MessageBox.Show("Deseja iniciar o serviço : " + nomeServico + " ?", "Iniciar", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

                    if (resultado == DialogResult.Yes)
                    {
                        ServicosWin.ServicosWin.StartService(nomeServico);
                        listaServicos();
                        MessageBox.Show("Serviço iniciado!");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Erro : " + ex.Message + Environment.NewLine + ex.InnerException, "Iniciar Serviço", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        //Reponsável para reiniciar o serviço
        private void btnReiniciar_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(nomeServico))
            {
                MessageBox.Show("Selecione o serviço!", "Servico", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                try
                {
                    DialogResult resultado = MessageBox.Show("Deseja reiniciar o serviço : " + nomeServico + " ?", "Reiniciar", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

                    if (resultado == DialogResult.Yes)
                    {
                        ServicosWin.ServicosWin.RestartService(nomeServico);
                        listaServicos();
                        MessageBox.Show("Serviço reiniciado!");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Erro : " + ex.Message + Environment.NewLine + ex.InnerException, "Reiniciar Serviço", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        //Reponsável para gerar a estrutura necessario para instalar o serviço
        private void btnGerarEstrutura_Click(object sender, EventArgs e)
        {
            try
            {
                //Sempre verifica se não retornou nenhum erro
                if (verificaForm() == 0)
                {
                    if (verificaPasta() == 0) 
                    {
                        if (copiaExecutavel() == 0)
                        {
                            if (criarXml() == 0)
                            {
                                if (instalarServico() == 0)
                                {
                                    if (abrirPortaFirewall() == 0)
                                    {
                                        listaServicos();
                                        limparCampos();
                                        MessageBox.Show("Serviço instalado com sucesso.");
                                    }
                                }
                            }
                        }
                        
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
                MessageBox.Show("Serviço não foi instalado.");
            }
        }

        //Responsável por verificar e pegar o valor dos inputs
        private int verificaForm()
        {
            try
            {
                if ((sPorta.Text != null) && (sLocalBanco.Text != null) && (sIPConexao.Text != null))
                {
                    ipServico = sIPConexao.Text;
                    portaServico = sPorta.Text;
                    bancoServico = sLocalBanco.Text;
                    return 0;
                }
                else
                {
                    MessageBox.Show("Algum campo obrigatório não foi informado!");
                    return 1;
                }  
            }catch
            {
                return 1;
            }
        }

        //Responsável por verificar se ja existe a pasta
        private int verificaPasta()
        {
            if (!Directory.Exists("" + pathServico + "/" + portaServico + ""))
            {
                //Se não tiver, é criado a pasta
                Directory.CreateDirectory("" + pathServico + "/" + portaServico + "");
                return 0;
            } else
            {
                MessageBox.Show("Essa pasta já existe!");
                return 1;
            }
        }

        //Reponsável por copiar os arquivos default do projeto
        private int copiaExecutavel()
        {
            try
            {
                //Pasta default do executavel
                String dirDefaultExe = "" + pathServico + "/exe/portal-bi-api.exe";

                //Copia o executavel
                System.IO.File.Copy(dirDefaultExe, "" + pathServico + "/" + portaServico + "/portal-bi-api.exe", true);

                return 0;
            }
            catch
            {
                MessageBox.Show("Ocorreu um erro ao copiar o executável do projeto!");
                return 1;
            }
        }

        //Reponsável por criar o xml
        private int criarXml()
        {
            try
            {
                XmlTextWriter writer = new XmlTextWriter(@"" + pathServico + "/" + portaServico +"/portal-bi-api.xml", null);

                //inicia o documento xml
                writer.WriteStartDocument();
                //escreve o elmento raiz
                writer.WriteStartElement("service");
                //Escreve os sub-elementos
                writer.WriteElementString("id", "" + nomeDefault + "" + portaServico + "");
                writer.WriteElementString("name", "" + nomeDefault + "" + portaServico + "");
                writer.WriteElementString("description", "Serviço do Portal Business Intelligence da Precisa Fábrica de Software");
                writer.WriteElementString("executable", "java");
                writer.WriteElementString("arguments", "-Xrs -Xmx256m -jar " + pathServico + "/app/portal-bi-api.jar --PORTAL_BI_URL=jdbc:firebirdsql://" + ipServico +"/" + bancoServico + " --server.port=" + portaServico + "");
                writer.WriteElementString("logmode", "rotate");
                // encerra o elemento raiz
                writer.WriteEndElement();
                //Escreve o XML para o arquivo e fecha o objeto escritor
                writer.Close();
                return 0;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
                return 1;
            }
        }

        //Reponsável por instalar o servico
        private int instalarServico()
        {
            try
            {
                string dirAtual = "" + pathServico + "/" + portaServico + "";

                Process cmd = new Process();
                cmd.StartInfo.FileName = "cmd.exe";
                cmd.StartInfo.RedirectStandardInput = true;
                cmd.StartInfo.RedirectStandardOutput = true;
                cmd.StartInfo.CreateNoWindow = true;
                cmd.StartInfo.UseShellExecute = false;
                cmd.Start();

                cmd.StandardInput.WriteLine("" + dirAtual + "/portal-bi-api.exe install service");
                cmd.StandardInput.Flush();
                cmd.StandardInput.Close();
                cmd.WaitForExit();

                ServicosWin.ServicosWin.StartService("" + nomeDefault + "" + portaServico + "");
                listaServicos();
                return 0;
            }
            catch 
            {
                MessageBox.Show("Não foi possivel instalar o serviço!");
                return 1;
            }
        }

        //Reponsável por abrir a porta no firewall
        private int abrirPortaFirewall()
        {
            try
            {
                string nomeServico = "" + nomeDefault + "" + portaServico;
                // Regras de Entrada
                string comandoEntrada = " netsh advfirewall firewall add rule name=" + nomeServico + " dir=in action=allow protocol=TCP localport=" + portaServico + " ";
                // Regras de Saída
                string comandoSaida = " netsh advfirewall firewall add rule name=" + nomeServico + " dir=out action=allow protocol=TCP localport=" + portaServico + " ";

                Process cmd = new Process();
                cmd.StartInfo.FileName = "cmd.exe";
                cmd.StartInfo.RedirectStandardInput = true;
                cmd.StartInfo.RedirectStandardOutput = true;
                cmd.StartInfo.CreateNoWindow = true;
                cmd.StartInfo.UseShellExecute = false;
                cmd.Start();

                cmd.StandardInput.WriteLine("" + comandoEntrada + "");
                cmd.StandardInput.WriteLine("" + comandoSaida + "");
                cmd.StandardInput.Flush();
                cmd.StandardInput.Close();
                cmd.WaitForExit();

                return 0;
            }
            catch
            {
                MessageBox.Show("Não foi possivel criar a porta do serviço no firewall!");
                return 1;
            }
        }

        //Reponsável por deletar o servico
        private void btnDeletarServico_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(nomeServico))
            {
                MessageBox.Show("Selecione o serviço!", "Servico", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                try
                {
                    DialogResult resultado = MessageBox.Show("Deseja deletar o serviço : " + nomeServico + " ?", "Deletar", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

                    if (resultado == DialogResult.Yes)
                    {
                        if ((sPorta.Text != ""))
                        {
                            portaServico = sPorta.Text;

                            ServicosWin.ServicosWin.DeleteService(nomeServico, pathServico, portaServico);

                            if (fecharPortaFirewall() == 0)
                            {
                                listaServicos();
                                MessageBox.Show("Serviço deletado!");
                                limparCampos();
                                listaServicos();
                            }
                        }
                        else
                        {
                            MessageBox.Show("Deve ser informado a porta do serviço!");
                        }
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Erro : " + ex.Message + Environment.NewLine + ex.InnerException, "Parar Serviço", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        //Reponsável por excluir a porta no firewall
        private int fecharPortaFirewall()
        {
            try
            {
                string nomeServico = "" + nomeDefault + "" + portaServico;
                // Regras de Entrada
                string comandoEntrada = " netsh advfirewall firewall delete rule name=" + nomeServico + " dir=in protocol=TCP localport=" + portaServico + " ";
                // Regras de Saída
                string comandoSaida = " netsh advfirewall firewall delete rule name=" + nomeServico + " dir=out protocol=TCP localport=" + portaServico + " ";

                Process cmd = new Process();
                cmd.StartInfo.FileName = "cmd.exe";
                cmd.StartInfo.RedirectStandardInput = true;
                cmd.StartInfo.RedirectStandardOutput = true;
                cmd.StartInfo.CreateNoWindow = true;
                cmd.StartInfo.UseShellExecute = false;
                cmd.Start();

                cmd.StandardInput.WriteLine("" + comandoEntrada + "");
                cmd.StandardInput.WriteLine("" + comandoSaida + "");
                cmd.StandardInput.Flush();
                cmd.StandardInput.Close();
                cmd.WaitForExit();

                return 0;
            }
            catch
            {
                MessageBox.Show("Não foi possivel criar a porta do serviço no firewall!");
                return 1;
            }
        }

        //Reponsável por limpar os campos apos submit
        private void limparCampos()
        {
            sPorta.Text = "";
            sLocalBanco.Text = "";
        }

        //Reponsável por buscar caminho do banco
        private void btnBuscarBanco_Click(object sender, EventArgs e)
        {
            DialogResult result = openFileBanco.ShowDialog();
            if (result == DialogResult.OK)
            {
                sLocalBanco.Text = openFileBanco.FileName;
            }
        }

    }
}
