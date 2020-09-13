namespace MonitorPortalBusinessIntelligence
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.lvServicos = new System.Windows.Forms.ListView();
            this.btnPararServico = new System.Windows.Forms.Button();
            this.btnIniciar = new System.Windows.Forms.Button();
            this.btnGerarEstrutura = new System.Windows.Forms.Button();
            this.sLocalBanco = new System.Windows.Forms.TextBox();
            this.lblPorta = new System.Windows.Forms.Label();
            this.sIPConexao = new System.Windows.Forms.TextBox();
            this.lblLocalBanco = new System.Windows.Forms.Label();
            this.lblIPConexao = new System.Windows.Forms.Label();
            this.sPorta = new System.Windows.Forms.TextBox();
            this.btnBuscarBanco = new System.Windows.Forms.Button();
            this.openFileBanco = new System.Windows.Forms.OpenFileDialog();
            this.folderBrowserArquivos = new System.Windows.Forms.FolderBrowserDialog();
            this.button1 = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.btnDeletarServico = new System.Windows.Forms.Button();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.btnRefresh = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBox1.BackColor = System.Drawing.Color.Transparent;
            this.groupBox1.Controls.Add(this.lvServicos);
            this.groupBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox1.ForeColor = System.Drawing.Color.White;
            this.groupBox1.Location = new System.Drawing.Point(28, 269);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(850, 248);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Serviços instalados";
            // 
            // lvServicos
            // 
            this.lvServicos.AllowColumnReorder = true;
            this.lvServicos.BackColor = System.Drawing.Color.White;
            this.lvServicos.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lvServicos.FullRowSelect = true;
            this.lvServicos.GridLines = true;
            this.lvServicos.HideSelection = false;
            this.lvServicos.Location = new System.Drawing.Point(3, 19);
            this.lvServicos.Name = "lvServicos";
            this.lvServicos.Size = new System.Drawing.Size(844, 226);
            this.lvServicos.TabIndex = 0;
            this.lvServicos.UseCompatibleStateImageBehavior = false;
            this.lvServicos.View = System.Windows.Forms.View.Details;
            this.lvServicos.SelectedIndexChanged += new System.EventHandler(this.lvServicos_SelectedIndexChanged);
            // 
            // btnPararServico
            // 
            this.btnPararServico.BackColor = System.Drawing.Color.Transparent;
            this.btnPararServico.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(254)))), ((int)(((byte)(204)))), ((int)(((byte)(64)))));
            this.btnPararServico.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(254)))), ((int)(((byte)(204)))), ((int)(((byte)(64)))));
            this.btnPararServico.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(254)))), ((int)(((byte)(204)))), ((int)(((byte)(64)))));
            this.btnPararServico.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnPararServico.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnPararServico.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnPararServico.Location = new System.Drawing.Point(438, 26);
            this.btnPararServico.Name = "btnPararServico";
            this.btnPararServico.Size = new System.Drawing.Size(185, 36);
            this.btnPararServico.TabIndex = 2;
            this.btnPararServico.Text = "Parar serviço";
            this.btnPararServico.UseVisualStyleBackColor = false;
            this.btnPararServico.Click += new System.EventHandler(this.btnPararServico_Click);
            // 
            // btnIniciar
            // 
            this.btnIniciar.BackColor = System.Drawing.Color.Transparent;
            this.btnIniciar.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(65)))), ((int)(((byte)(132)))), ((int)(((byte)(243)))));
            this.btnIniciar.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(65)))), ((int)(((byte)(132)))), ((int)(((byte)(243)))));
            this.btnIniciar.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(65)))), ((int)(((byte)(132)))), ((int)(((byte)(243)))));
            this.btnIniciar.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnIniciar.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnIniciar.ForeColor = System.Drawing.Color.White;
            this.btnIniciar.Location = new System.Drawing.Point(229, 26);
            this.btnIniciar.Name = "btnIniciar";
            this.btnIniciar.Size = new System.Drawing.Size(185, 36);
            this.btnIniciar.TabIndex = 4;
            this.btnIniciar.Text = "Iniciar serviço";
            this.btnIniciar.UseVisualStyleBackColor = false;
            this.btnIniciar.Click += new System.EventHandler(this.btnIniciar_Click);
            // 
            // btnGerarEstrutura
            // 
            this.btnGerarEstrutura.BackColor = System.Drawing.Color.Transparent;
            this.btnGerarEstrutura.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(15)))), ((int)(((byte)(157)))), ((int)(((byte)(88)))));
            this.btnGerarEstrutura.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(15)))), ((int)(((byte)(157)))), ((int)(((byte)(88)))));
            this.btnGerarEstrutura.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(15)))), ((int)(((byte)(157)))), ((int)(((byte)(88)))));
            this.btnGerarEstrutura.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnGerarEstrutura.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnGerarEstrutura.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnGerarEstrutura.Location = new System.Drawing.Point(23, 26);
            this.btnGerarEstrutura.Name = "btnGerarEstrutura";
            this.btnGerarEstrutura.Size = new System.Drawing.Size(185, 36);
            this.btnGerarEstrutura.TabIndex = 5;
            this.btnGerarEstrutura.Text = "Instalar serviço";
            this.btnGerarEstrutura.UseVisualStyleBackColor = false;
            this.btnGerarEstrutura.Click += new System.EventHandler(this.btnGerarEstrutura_Click);
            // 
            // sLocalBanco
            // 
            this.sLocalBanco.Location = new System.Drawing.Point(28, 102);
            this.sLocalBanco.Multiline = true;
            this.sLocalBanco.Name = "sLocalBanco";
            this.sLocalBanco.Size = new System.Drawing.Size(453, 36);
            this.sLocalBanco.TabIndex = 6;
            // 
            // lblPorta
            // 
            this.lblPorta.AutoSize = true;
            this.lblPorta.BackColor = System.Drawing.Color.Transparent;
            this.lblPorta.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPorta.ForeColor = System.Drawing.Color.White;
            this.lblPorta.Location = new System.Drawing.Point(767, 82);
            this.lblPorta.Name = "lblPorta";
            this.lblPorta.Size = new System.Drawing.Size(111, 17);
            this.lblPorta.TabIndex = 7;
            this.lblPorta.Text = "Porta do serviço";
            // 
            // sIPConexao
            // 
            this.sIPConexao.Location = new System.Drawing.Point(530, 102);
            this.sIPConexao.Multiline = true;
            this.sIPConexao.Name = "sIPConexao";
            this.sIPConexao.Size = new System.Drawing.Size(215, 36);
            this.sIPConexao.TabIndex = 8;
            // 
            // lblLocalBanco
            // 
            this.lblLocalBanco.AutoSize = true;
            this.lblLocalBanco.BackColor = System.Drawing.Color.Transparent;
            this.lblLocalBanco.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblLocalBanco.ForeColor = System.Drawing.Color.White;
            this.lblLocalBanco.Location = new System.Drawing.Point(25, 82);
            this.lblLocalBanco.Name = "lblLocalBanco";
            this.lblLocalBanco.Size = new System.Drawing.Size(189, 17);
            this.lblLocalBanco.TabIndex = 9;
            this.lblLocalBanco.Text = "Caminho do banco de dados";
            // 
            // lblIPConexao
            // 
            this.lblIPConexao.AutoSize = true;
            this.lblIPConexao.BackColor = System.Drawing.Color.Transparent;
            this.lblIPConexao.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblIPConexao.ForeColor = System.Drawing.Color.White;
            this.lblIPConexao.Location = new System.Drawing.Point(527, 82);
            this.lblIPConexao.Name = "lblIPConexao";
            this.lblIPConexao.Size = new System.Drawing.Size(146, 17);
            this.lblIPConexao.TabIndex = 10;
            this.lblIPConexao.Text = "IP do banco de dados";
            // 
            // sPorta
            // 
            this.sPorta.Location = new System.Drawing.Point(770, 102);
            this.sPorta.Multiline = true;
            this.sPorta.Name = "sPorta";
            this.sPorta.Size = new System.Drawing.Size(108, 36);
            this.sPorta.TabIndex = 11;
            // 
            // btnBuscarBanco
            // 
            this.btnBuscarBanco.BackColor = System.Drawing.Color.Transparent;
            this.btnBuscarBanco.BackgroundImage = global::MonitorPortalBusinessIntelligence.Properties.Resources.buscar;
            this.btnBuscarBanco.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.btnBuscarBanco.CausesValidation = false;
            this.btnBuscarBanco.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnBuscarBanco.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnBuscarBanco.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnBuscarBanco.Location = new System.Drawing.Point(466, 102);
            this.btnBuscarBanco.Name = "btnBuscarBanco";
            this.btnBuscarBanco.Size = new System.Drawing.Size(37, 36);
            this.btnBuscarBanco.TabIndex = 12;
            this.btnBuscarBanco.UseVisualStyleBackColor = false;
            this.btnBuscarBanco.Click += new System.EventHandler(this.btnBuscarBanco_Click);
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.Transparent;
            this.button1.BackgroundImage = global::MonitorPortalBusinessIntelligence.Properties.Resources.logoBranco1;
            this.button1.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.button1.FlatAppearance.BorderSize = 0;
            this.button1.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Transparent;
            this.button1.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Transparent;
            this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button1.ForeColor = System.Drawing.Color.White;
            this.button1.Location = new System.Drawing.Point(13, 2);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(180, 58);
            this.button1.TabIndex = 16;
            this.button1.UseVisualStyleBackColor = false;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.BackColor = System.Drawing.Color.Transparent;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 7F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.ForeColor = System.Drawing.Color.White;
            this.label4.Location = new System.Drawing.Point(28, 47);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(138, 13);
            this.label4.TabIndex = 19;
            this.label4.Text = "Precisa Fábrica de Software";
            // 
            // btnDeletarServico
            // 
            this.btnDeletarServico.BackColor = System.Drawing.Color.Transparent;
            this.btnDeletarServico.FlatAppearance.BorderColor = System.Drawing.Color.FromArgb(((int)(((byte)(218)))), ((int)(((byte)(68)))), ((int)(((byte)(55)))));
            this.btnDeletarServico.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(218)))), ((int)(((byte)(68)))), ((int)(((byte)(55)))));
            this.btnDeletarServico.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(218)))), ((int)(((byte)(68)))), ((int)(((byte)(55)))));
            this.btnDeletarServico.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnDeletarServico.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnDeletarServico.ForeColor = System.Drawing.Color.White;
            this.btnDeletarServico.Location = new System.Drawing.Point(642, 26);
            this.btnDeletarServico.Name = "btnDeletarServico";
            this.btnDeletarServico.Size = new System.Drawing.Size(185, 36);
            this.btnDeletarServico.TabIndex = 20;
            this.btnDeletarServico.Text = "Deletar serviço";
            this.btnDeletarServico.UseVisualStyleBackColor = false;
            this.btnDeletarServico.Click += new System.EventHandler(this.btnDeletarServico_Click);
            // 
            // groupBox3
            // 
            this.groupBox3.BackColor = System.Drawing.Color.Transparent;
            this.groupBox3.Controls.Add(this.btnIniciar);
            this.groupBox3.Controls.Add(this.btnDeletarServico);
            this.groupBox3.Controls.Add(this.btnPararServico);
            this.groupBox3.Controls.Add(this.btnGerarEstrutura);
            this.groupBox3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox3.ForeColor = System.Drawing.Color.White;
            this.groupBox3.Location = new System.Drawing.Point(28, 165);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(850, 81);
            this.groupBox3.TabIndex = 21;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Painel de controle";
            // 
            // btnRefresh
            // 
            this.btnRefresh.BackColor = System.Drawing.Color.Transparent;
            this.btnRefresh.BackgroundImage = global::MonitorPortalBusinessIntelligence.Properties.Resources.refresh__1_;
            this.btnRefresh.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.btnRefresh.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnRefresh.FlatAppearance.MouseDownBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(25)))), ((int)(((byte)(135)))), ((int)(((byte)(139)))));
            this.btnRefresh.FlatAppearance.MouseOverBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(25)))), ((int)(((byte)(135)))), ((int)(((byte)(139)))));
            this.btnRefresh.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnRefresh.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnRefresh.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnRefresh.Location = new System.Drawing.Point(845, 18);
            this.btnRefresh.Name = "btnRefresh";
            this.btnRefresh.Size = new System.Drawing.Size(33, 28);
            this.btnRefresh.TabIndex = 22;
            this.btnRefresh.UseVisualStyleBackColor = false;
            this.btnRefresh.Click += new System.EventHandler(this.btnRefresh_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(238)))));
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(903, 544);
            this.Controls.Add(this.btnRefresh);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.btnBuscarBanco);
            this.Controls.Add(this.sPorta);
            this.Controls.Add(this.lblIPConexao);
            this.Controls.Add(this.lblLocalBanco);
            this.Controls.Add(this.sIPConexao);
            this.Controls.Add(this.lblPorta);
            this.Controls.Add(this.sLocalBanco);
            this.Controls.Add(this.groupBox1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ForeColor = System.Drawing.Color.White;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Monitor Portal Business Intelligence - Versão 1.0";
            this.groupBox1.ResumeLayout(false);
            this.groupBox3.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.ListView lvServicos;
        private System.Windows.Forms.Button btnPararServico;
        private System.Windows.Forms.Button btnIniciar;
        private System.Windows.Forms.Button btnGerarEstrutura;
        private System.Windows.Forms.TextBox sLocalBanco;
        private System.Windows.Forms.Label lblPorta;
        private System.Windows.Forms.TextBox sIPConexao;
        private System.Windows.Forms.Label lblLocalBanco;
        private System.Windows.Forms.Label lblIPConexao;
        private System.Windows.Forms.TextBox sPorta;
        private System.Windows.Forms.Button btnBuscarBanco;
        private System.Windows.Forms.OpenFileDialog openFileBanco;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserArquivos;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button btnDeletarServico;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button btnRefresh;
    }
}

