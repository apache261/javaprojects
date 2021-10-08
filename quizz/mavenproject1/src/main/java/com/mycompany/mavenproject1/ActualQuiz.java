/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import javax.swing.JPanel;

/**
 *
 * @author lynx
 */
class User {

    private String name;
    private int prevScore;
    private int currentScore;
    private int currentMistake;
    private int currentStage;
    private int maxStage;

    public User(String name) {
        this.setName(name);
        this.setCurrentMistake(0);
        this.setPrevScore(0);
        this.setCurrentStage(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrevScore() {
        return prevScore;
    }

    public void setPrevScore(int prevScore) {
        this.prevScore = prevScore;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getCurrentMistake() {
        return currentMistake;
    }

    public void setCurrentMistake(int currentMistake) {
        this.currentMistake = currentMistake;
    }

    public int getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }

    public int getMaxStage() {
        return maxStage;
    }

    public void setMaxStage(int maxStage) {
        this.maxStage = maxStage;
    }
}

public class ActualQuiz extends javax.swing.JFrame {

    /**
     * Creates new form ActualQuiz
     */
    private User user;
    private Quiz quiz1;
    private Quiz2 quiz2;
    private Quiz3 quiz3;
    private Quiz4 quiz4;
    private Quiz5 quiz5;
    private Quiz6 quiz6;
    private Quiz7 quiz7;
    private Quiz8 quiz8;

    public ActualQuiz(String name) {
        initComponents(); // init components
        quiz1 = new Quiz(); // Initialiaze quiz1
        quiz2 = new Quiz2(); // Initialiaze quiz2
        quiz3 = new Quiz3(); // Initialiaze quiz3
        quiz4 = new Quiz4(); // Initialiaze quiz4
        quiz5 = new Quiz5(); // Initialiaze quiz5
        quiz6 = new Quiz6(); // Initialiaze quiz6
        quiz7 = new Quiz7(); // Initialiaze quiz7
        quiz8 = new Quiz8(); // Initialiaze quiz8
        this.user = new User(name); // set Username
        this.user.setMaxStage(8);
//        this.playName.setText(name); // set text to the right top label
        this.labelCurrent.setText(Integer.toString(this.user.getCurrentScore()));

        this.quizAreaPanel.removeAll(); // remove other components
        this.quizAreaPanel.repaint();
        this.quizAreaPanel.revalidate();
        this.quizAreaPanel.add(this.quiz1); // add the new panel
        this.quizAreaPanel.repaint();
        this.quizAreaPanel.revalidate();
        this.updateFrameTitle();
//       this.quiz1.setVisible(true);
    }

    public ActualQuiz() {
        initComponents();
    }

    private void updateFrameTitle() {
        this.setTitle("Stage " + Integer.toString(this.user.getCurrentStage()) + "/" + Integer.toString(this.user.getMaxStage()));
    }

    private void changePanel(JPanel jpan) {
        this.quizAreaPanel.removeAll(); // remove other components
        this.quizAreaPanel.repaint();
        this.quizAreaPanel.revalidate();
        this.quizAreaPanel.add(jpan); // add the new panel
        this.quizAreaPanel.repaint();
        this.quizAreaPanel.revalidate();
    }

    private void showCorrect() {
        this.jLabel1.setText("Correct");
        this.jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        this.user.setCurrentScore((this.user.getCurrentScore() + 1));
        this.labelCurrent.setText(Integer.toString(this.user.getCurrentScore()));
    }

    private void showError() {
        this.jLabel1.setText("Wrong");
        this.jLabel1.setForeground(new java.awt.Color(255, 51, 51));
    }

    private boolean validateQuiz1() {
        int answerIndex = 3;
        boolean userAnswer = this.quiz1.getAnswer() == answerIndex;
        if (userAnswer) {

            this.showCorrect();
        } else {
            this.showError();
        }

        return true;
    }

    private boolean validateQuiz2() {
        int answerIndex = 1;
        boolean userAnswer = this.quiz2.getAnswer() == answerIndex;
        if (userAnswer) {

            this.showCorrect();
        } else {
            this.showError();
        }
        return true;
    }

    private boolean validateQuiz3() {
        int answerIndex = 1;
        boolean userAnswer = this.quiz3.getAnswer() == answerIndex;
        if (userAnswer) {

            this.showCorrect();
        } else {
            this.showError();
        }
        return true;
    }

    private boolean validateQuiz4() {
        int answerIndex = 1;
        boolean userAnswer = this.quiz4.getAnswer() == answerIndex;
        if (userAnswer) {

            this.showCorrect();
        } else {
            this.showError();
        }
        return true;
    }

    private boolean validateQuiz5() {
        int answerIndex = 1;
        boolean userAnswer = this.quiz5.getAnswer() == answerIndex;
        if (userAnswer) {

            this.showCorrect();
        } else {
            this.showError();
        }
        return true;
    }

    private boolean validateQuiz6() {
        int answerIndex = 1;
        boolean userAnswer = this.quiz6.getAnswer() == answerIndex;
        if (userAnswer) {

            this.showCorrect();
        } else {
            this.showError();
        }
        return true;
    }

    private boolean validateQuiz7() {
        int answerIndex = 1;
        boolean userAnswer = this.quiz7.getAnswer() == answerIndex;
        if (userAnswer) {

            this.showCorrect();
        } else {
            this.showError();
        }
        return true;
    }

    private boolean validateQuiz8() {
        int answerIndex = 1;
        boolean userAnswer = this.quiz8.getAnswer() == answerIndex;
        if (userAnswer) {

            this.showCorrect();
        } else {
            this.showError();
        }
        return true;
    }

    private void endQuiz() {
       
        Score score = new com.mycompany.mavenproject1.Score(this.user.getCurrentScore(), this.user.getMaxStage(), this.user.getName());
        
        score.setVisible(true);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelCurrentStage = new javax.swing.JLabel();
        labelCurrent = new javax.swing.JLabel();
        labelMax = new javax.swing.JLabel();
        playName = new javax.swing.JLabel();
        btnSub = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        quizAreaPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("dsd");
        setResizable(false);

        labelCurrentStage.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelCurrentStage.setText("Score:");

        labelCurrent.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelCurrent.setText("12");

        labelMax.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelMax.setText("/8");

        playName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        btnSub.setBackground(new java.awt.Color(0, 153, 51));
        btnSub.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSub.setForeground(new java.awt.Color(255, 255, 255));
        btnSub.setText("Proceed");
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 252, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelCurrentStage)
                .addGap(18, 18, 18)
                .addComponent(labelCurrent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMax, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(playName, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(playName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCurrentStage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCurrent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelMax)
                        .addComponent(btnSub, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );

        quizAreaPanel.setName(""); // NOI18N
        quizAreaPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(quizAreaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quizAreaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubActionPerformed
        int cur = this.user.getCurrentStage();

        switch (cur) {
            case 1:
                this.changePanel(quiz2);
                this.validateQuiz1();
                break;
            case 2:
                this.changePanel(quiz3);
                this.validateQuiz2();
                break;
            case 3:
                this.changePanel(quiz4);
                this.validateQuiz3();
                break;
            case 4:
                this.changePanel(quiz5);
                this.validateQuiz4();
                break;
            case 5:
                this.changePanel(quiz6);
                this.validateQuiz5();
                break;
            case 6:
                this.changePanel(quiz7);
                this.validateQuiz6();
                break;
            case 7:
                this.changePanel(quiz8);
                this.validateQuiz7();
                break;
            case 8:
                this.validateQuiz8();
                break;
            default:
                break;
        }

        if (this.user.getCurrentStage() == this.user.getMaxStage()) {
            this.endQuiz();
        } else {
            this.user.setCurrentStage((cur + 1));
            this.updateFrameTitle();
        }

//        this.labelCurrent.setText(Integer.toString(this.user.getCurrentStage()));

    }//GEN-LAST:event_btnSubActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ActualQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualQuiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSub;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCurrent;
    private javax.swing.JLabel labelCurrentStage;
    private javax.swing.JLabel labelMax;
    private javax.swing.JLabel playName;
    private javax.swing.JPanel quizAreaPanel;
    // End of variables declaration//GEN-END:variables
}
