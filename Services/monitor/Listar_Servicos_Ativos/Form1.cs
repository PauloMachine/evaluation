using System;
using System.Windows.Forms;
using System.Diagnostics;
using System.Management;
using ServicosWin;

namespace Listar_Servicos_Ativos
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        string nomeServico = "";

        private void btnListarServicos_Click(object sender, EventArgs e)
        {
            ManagementClass management = new ManagementClass("Win32_Process");
            ManagementObjectCollection mCollection = management.GetInstances();

            foreach (ManagementObject process in mCollection)
            {
                ListViewItem novoListViewItem = new ListViewItem();

                novoListViewItem.Text = (process["ProcessId"].ToString());
                novoListViewItem.SubItems.Add((string)process["Name"]);
                novoListViewItem.SubItems.Add((string)process["ExecutablePath"]);

                try
                {
                    FileVersionInfo info = FileVersionInfo.GetVersionInfo((string)process["ExecutablePath"]);
                    novoListViewItem.SubItems.Add(info.FileDescription);
                }
                catch
                {
                    novoListViewItem.SubItems.Add("Não Disponível");
                }

                lvServicosAtivos.Items.Add(novoListViewItem);
            }
        }

        private void lvServicosAtivos_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                nomeServico = lvServicosAtivos.SelectedItems[0].SubItems[1].Text;
                MessageBox.Show("Serviço selecionado -> :" + nomeServico, "Serviço", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            catch
            {
                nomeServico = "";
            }
        }
    }
}
