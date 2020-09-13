namespace Listar_Servicos_Ativos
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.lvServicosAtivos = new System.Windows.Forms.ListView();
            this.ID = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Nome = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Localizacao = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Descricao = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.btnListarServicos = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBox1.Controls.Add(this.lvServicosAtivos);
            this.groupBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox1.ForeColor = System.Drawing.Color.White;
            this.groupBox1.Location = new System.Drawing.Point(13, 13);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(689, 422);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Serviços Ativos do Windows";
            // 
            // lvServicosAtivos
            // 
            this.lvServicosAtivos.AllowColumnReorder = true;
            this.lvServicosAtivos.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(192)))));
            this.lvServicosAtivos.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.lvServicosAtivos.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.ID,
            this.Nome,
            this.Localizacao,
            this.Descricao});
            this.lvServicosAtivos.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lvServicosAtivos.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lvServicosAtivos.FullRowSelect = true;
            this.lvServicosAtivos.GridLines = true;
            this.lvServicosAtivos.Location = new System.Drawing.Point(3, 20);
            this.lvServicosAtivos.Name = "lvServicosAtivos";
            this.lvServicosAtivos.Size = new System.Drawing.Size(683, 399);
            this.lvServicosAtivos.TabIndex = 0;
            this.lvServicosAtivos.UseCompatibleStateImageBehavior = false;
            this.lvServicosAtivos.View = System.Windows.Forms.View.Details;
            this.lvServicosAtivos.SelectedIndexChanged += new System.EventHandler(this.lvServicosAtivos_SelectedIndexChanged);
            // 
            // ID
            // 
            this.ID.Text = "ID";
            // 
            // Nome
            // 
            this.Nome.Text = "Nome";
            this.Nome.Width = 250;
            // 
            // Localizacao
            // 
            this.Localizacao.Text = "Localização";
            this.Localizacao.Width = 400;
            // 
            // Descricao
            // 
            this.Descricao.Text = "Descrição";
            this.Descricao.Width = 500;
            // 
            // btnListarServicos
            // 
            this.btnListarServicos.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnListarServicos.Location = new System.Drawing.Point(16, 441);
            this.btnListarServicos.Name = "btnListarServicos";
            this.btnListarServicos.Size = new System.Drawing.Size(194, 40);
            this.btnListarServicos.TabIndex = 1;
            this.btnListarServicos.Text = "Listar Serviços Ativos";
            this.btnListarServicos.UseVisualStyleBackColor = true;
            this.btnListarServicos.Click += new System.EventHandler(this.btnListarServicos_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.SteelBlue;
            this.ClientSize = new System.Drawing.Size(714, 491);
            this.Controls.Add(this.btnListarServicos);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Listando os serviços ativos do Windows";
            this.groupBox1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.ListView lvServicosAtivos;
        private System.Windows.Forms.Button btnListarServicos;
        private System.Windows.Forms.ColumnHeader ID;
        private System.Windows.Forms.ColumnHeader Nome;
        private System.Windows.Forms.ColumnHeader Localizacao;
        private System.Windows.Forms.ColumnHeader Descricao;
    }
}

