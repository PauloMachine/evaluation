using System;
using System.ServiceProcess;
using System.Diagnostics;
using System.IO;

namespace ServicosWin
{
    public class ServicosWin
    {
        public static void StartService(string serviceName, int timeoutMilliseconds = 10000)
        {
            ServiceController service = new ServiceController(serviceName);
            try
            {
                TimeSpan timeout = TimeSpan.FromMilliseconds(timeoutMilliseconds);
                service.Refresh();
                if (service.Status == ServiceControllerStatus.Stopped)
                {
                    service.Start();
                    service.WaitForStatus(ServiceControllerStatus.Running, timeout);
                }
                else
                {
                    throw new Exception(string.Format("{0}: O serviço já se encontra iniciado.", service.DisplayName));
                }
            }
            catch
            {
                throw; 
            }
        }
        public static void StopService(string serviceName, int timeoutMilliseconds = 10000)
        {
            ServiceController service = new ServiceController(serviceName);
            try
            {
                TimeSpan timeout = TimeSpan.FromMilliseconds(timeoutMilliseconds);

                service.Refresh();

                if (service.Status == ServiceControllerStatus.Running)
                {
                    service.Stop();
                    service.WaitForStatus(ServiceControllerStatus.Stopped, timeout);
                }
                else
                {
                    if (service.Status == ServiceControllerStatus.Stopped) {
                        throw new Exception(string.Format("{0}: O serviço já se encontra parado.", service.DisplayName));
                    }
                }
            }
            catch
            {
                throw; 
            }
        }

        public static void RestartService(string serviceName, int timeoutMilliseconds=10000)
        {
            ServiceController service = new ServiceController(serviceName);
            try
            {
                int millisec1 = Environment.TickCount;
                TimeSpan timeout = TimeSpan.FromMilliseconds(timeoutMilliseconds);

                service.Refresh();

                if (service.Status != ServiceControllerStatus.Stopped)
                {
                    service.Stop();
                    service.WaitForStatus(ServiceControllerStatus.Stopped, timeout);

                    // conta o resto do timeout
                    int millisec2 = Environment.TickCount;
                    timeout = TimeSpan.FromMilliseconds(timeoutMilliseconds - (millisec2 - millisec1));

                    service.Start();
                    service.WaitForStatus(ServiceControllerStatus.Running, timeout);
                }
                else
                {
                    service.Start();
                }
            }
            catch
            {
                throw; 
            }
        }

        public static void DeleteService(string serviceName, String pathServico, String portaServico, int timeoutMilliseconds = 10000)
        {
            ServiceController service = new ServiceController(serviceName);
            try
            {
                int millisec1 = Environment.TickCount;
                TimeSpan timeout = TimeSpan.FromMilliseconds(timeoutMilliseconds);

                service.Refresh();

                if (service.Status != ServiceControllerStatus.Running)
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

                        cmd.StandardInput.WriteLine("" + dirAtual + "/portal-bi-api.exe uninstall service");
                        cmd.StandardInput.Flush();
                        cmd.StandardInput.Close();
                        cmd.WaitForExit();

                        //Deleta a pasta
                        Directory.Delete(dirAtual, true);
                    }
                    catch
                    {
                        throw;
                    }
                } else
                {
                    // para o serviço
                    service.Stop();
                    service.WaitForStatus(ServiceControllerStatus.Stopped, timeout);

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

                        cmd.StandardInput.WriteLine("" + dirAtual + "/portal-bi-api.exe uninstall service");
                        cmd.StandardInput.Flush();
                        cmd.StandardInput.Close();
                        cmd.WaitForExit();

                        //Deleta a pasta
                        Directory.Delete(dirAtual, true);
                    }
                    catch
                    {
                        throw;
                    }
                }
            }
            catch
            {
                throw;
            }
        }
    }
}
