package telas;

import classes.Listagem;
import classes.Paciente;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class TelaInicial extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaInicial.class.getName());

    public TelaInicial() {
        initComponents();
        atualizarTabela();
    }
    
    
    public void atualizarTabela() {
        String[] colunas = {
            "Paciente", "CPF", "Telefone", "Data",
            "Já era paciente?", "Consulta Realizada"
        };

        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Paciente> listaCompleta = Listagem.getListaPacientes();
       

        for (Paciente p : listaCompleta) {
            
            String[] linha = {   
                p.getNome(),
                p.getCpf(),
                p.getTelefone(),
                sdf.format(p.getDataConsulta()),
                falseOrTrue(Boolean.toString(p.isEraPaciente())),
                falseOrTrue(Boolean.toString(p.isConsultaRealizada()))
            };
            tableModel.addRow(linha);
        }

        table_consultas.setModel(tableModel);
    }
    
    private String falseOrTrue(String bool) {
        String falseTrue = "";
        
        if ("false".equals(bool)) {
           falseTrue = "Não";
        } else if ("true".equals(bool)) {
           falseTrue = "Sim";
        }
       
        return falseTrue;
    }
    
    public int getPosicaoPaciente(){

        int posPaciente = table_consultas.getSelectedRow();


        
        if(posPaciente == -1){
            JOptionPane.showMessageDialog(rootPane, "Selecione um aluno");
        }
        
        return posPaciente;
    }
    
    private void excluirPaciente(int posPaciente){

        if(posPaciente >= 0){


            String[] options = { "Não", "Sim" };

            int deletar = JOptionPane.showOptionDialog(
                    rootPane,
                    "Tem certeza que deseja excluir?", 
                    "Exclusão de paciente", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    options, 
                    options[0]
            );

            if(deletar == 1){
                 
               Listagem.removePaciente(posPaciente);

               atualizarTabela();
            }else{
                
               table_consultas.clearSelection();             
            }
        }  
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_consultas = new javax.swing.JTable();
        btn_excluir_consulta = new javax.swing.JButton();
        btn_finalizar_consulta = new javax.swing.JButton();
        btn_nova_consulta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("Boas vindas ao sistema de agendamento");

        table_consultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(table_consultas);

        btn_excluir_consulta.setText("Excluir Consulta");
        btn_excluir_consulta.addActionListener(this::btn_excluir_consultaActionPerformed);

        btn_finalizar_consulta.setText("Finalizar Consulta");
        btn_finalizar_consulta.addActionListener(this::btn_finalizar_consultaActionPerformed);

        btn_nova_consulta.setText("Nova Consulta");
        btn_nova_consulta.addActionListener(this::btn_nova_consultaActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_nova_consulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_excluir_consulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_finalizar_consulta)
                        .addGap(48, 48, 48))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_excluir_consulta)
                    .addComponent(btn_finalizar_consulta)
                    .addComponent(btn_nova_consulta))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_finalizar_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizar_consultaActionPerformed
        // TODO add your handling code here:
       DetalhesConsulta telaDetalhes = new DetalhesConsulta(this);
       telaDetalhes.setVisible(true);
        
    }//GEN-LAST:event_btn_finalizar_consultaActionPerformed

    private void btn_excluir_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluir_consultaActionPerformed
        // TODO add your handling code here:
        excluirPaciente(getPosicaoPaciente());
    }//GEN-LAST:event_btn_excluir_consultaActionPerformed

    private void btn_nova_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nova_consultaActionPerformed
        // TODO add your handling code here:
        CadastroConsulta telaCadastro = new CadastroConsulta(this);
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_btn_nova_consultaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaInicial().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_excluir_consulta;
    private javax.swing.JButton btn_finalizar_consulta;
    private javax.swing.JButton btn_nova_consulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_consultas;
    // End of variables declaration//GEN-END:variables
}
