/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Game;

import Register.My_CNX;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Login.Login;
import Main.Lobby;
import static Main.Lobby.name;
import static Main.Lobby.point;
import Main.Rank_2;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author 박주형
 */
public class RockScissorPaper extends javax.swing.JFrame {

    /**
     * Creates new form rps
     */
    
    int mouseX;
    int mouseY;
    int PlayerX;
    int PlayerY;
    int ButtonX;
    int ButtonY;
    public static String name;
    public static String point;
    JButton[] buttons = new JButton[3];
    int count = 0;
    int count2 = 0;
    int StartNum = 1;
    int rsp[] = new int[3]; // 초기 25개의 버튼에 넣을 숫자
    int rspint[] = new int[3]; // 버튼 클릭시 들어갈 숫자
    Timer t = new Timer();
    Timer gameTimer = new Timer();
    public static String gameName = "머리쓰는 가위바위보";
    public long oldTime;
    public long currentTime;
    public long realTime;
    private String Time;
    public String currentPoint;
    public static String currentPoint2;
    public static String str;
    private int sqlSaveRealTime;
   Random r = new Random();
   Border idBorder = BorderFactory.createMatteBorder(1, 1, 1, 20, new Color(255,153,153)); // 빨
   Border idBorder2 = BorderFactory.createMatteBorder(1, 1, 1, 20, new Color(51,204,255)); // 파
    public RockScissorPaper() {
        initComponents();
        getUserInfo(); // 포인트랑 닉네임 불러오기
        CountNum.setVisible(false);
        TimerLabel.setVisible(false);
        InputButtonValue.setVisible(false);
        GameName.setText(gameName); // 게임 타이틀 지정
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Close = new javax.swing.JLabel();
        Minimize = new javax.swing.JLabel();
        BackKey = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        NickNameLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        RankButton = new javax.swing.JButton();
        pointLabel = new javax.swing.JLabel();
        GameExplain = new javax.swing.JButton();
        Restart = new javax.swing.JButton();
        GameLabelPanel = new javax.swing.JPanel();
        GameName = new javax.swing.JLabel();
        TimerLabel = new javax.swing.JLabel();
        InputButtonValue = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        gameStartButton = new javax.swing.JButton();
        CountNum = new javax.swing.JLabel();
        GamePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        Close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Close.setText(" x");
        Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CloseMouseExited(evt);
            }
        });

        Minimize.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Minimize.setText(" -");
        Minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizeMouseExited(evt);
            }
        });

        BackKey.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BackKey.setForeground(new java.awt.Color(102, 102, 102));
        BackKey.setText("<");
        BackKey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackKeyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackKeyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackKeyMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackKey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1014, Short.MAX_VALUE)
                .addComponent(Minimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Close)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Close)
                    .addComponent(Minimize)
                    .addComponent(BackKey))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NickNameLabel.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        NickNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NickNameLabel.setText("박주형님 환영합니다.");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/humen.png"))); // NOI18N

        RankButton.setBackground(new java.awt.Color(0, 98, 157));
        RankButton.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        RankButton.setForeground(new java.awt.Color(255, 255, 255));
        RankButton.setText("가위바위보 랭킹");
        RankButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RankButtonActionPerformed(evt);
            }
        });

        pointLabel.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        pointLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pointLabel.setText("포인트");

        GameExplain.setBackground(new java.awt.Color(51, 204, 255));
        GameExplain.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        GameExplain.setForeground(new java.awt.Color(255, 255, 255));
        GameExplain.setText("게임 설명");
        GameExplain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameExplainActionPerformed(evt);
            }
        });

        Restart.setBackground(new java.awt.Color(255, 153, 153));
        Restart.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        Restart.setForeground(new java.awt.Color(255, 255, 255));
        Restart.setText("다시하기");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NickNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(pointLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RankButton, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GameExplain, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Restart, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NickNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pointLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(RankButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GameExplain, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Restart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        GameLabelPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GameName.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        GameName.setText("GameLabel");
        GameLabelPanel.add(GameName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 250, 30));

        TimerLabel.setBackground(new java.awt.Color(255, 255, 255));
        TimerLabel.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        TimerLabel.setForeground(new java.awt.Color(255, 102, 102));
        TimerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimerLabel.setText("00분 00초");
        GameLabelPanel.add(TimerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 2, 90, 40));

        InputButtonValue.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        InputButtonValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InputButtonValue.setText("1를 누르세요");
        GameLabelPanel.add(InputButtonValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 8, 280, 30));

        getContentPane().add(GameLabelPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 810, 40));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gameStartButton.setBackground(new java.awt.Color(213, 89, 91));
        gameStartButton.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        gameStartButton.setForeground(new java.awt.Color(255, 255, 255));
        gameStartButton.setText("게임 시작");
        gameStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameStartButtonActionPerformed(evt);
            }
        });
        jPanel3.add(gameStartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 170, 97));

        CountNum.setFont(new java.awt.Font("굴림", 1, 200)); // NOI18N
        CountNum.setForeground(new java.awt.Color(255, 153, 153));
        CountNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CountNum.setText("3");
        jPanel3.add(CountNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 105, 256, 252));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 800, 510));

        GamePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout GamePanelLayout = new javax.swing.GroupLayout(GamePanel);
        GamePanel.setLayout(GamePanelLayout);
        GamePanelLayout.setHorizontalGroup(
            GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );
        GamePanelLayout.setVerticalGroup(
            GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        getContentPane().add(GamePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 790, 490));

        setSize(new java.awt.Dimension(1100, 570));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseMouseClicked

    private void CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseEntered
        // TODO add your handling code here:
        Close.setForeground(Color.red);
    }//GEN-LAST:event_CloseMouseEntered

    private void CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseExited
        // TODO add your handling code here:
        Close.setForeground(Color.black);
    }//GEN-LAST:event_CloseMouseExited

    private void MinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(RockScissorPaper.ICONIFIED);
    }//GEN-LAST:event_MinimizeMouseClicked

    private void MinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseEntered
        // TODO add your handling code here:
        Minimize.setForeground(Color.gray);
    }//GEN-LAST:event_MinimizeMouseEntered

    private void MinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseExited
        // TODO add your handling code here:
        Minimize.setForeground(Color.black);
    }//GEN-LAST:event_MinimizeMouseExited

    private void BackKeyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackKeyMouseClicked
        // TODO add your handling code here:
        Lobby lobby = new Lobby();
        lobby.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackKeyMouseClicked

    private void BackKeyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackKeyMouseEntered
        // TODO add your handling code here:
        BackKey.setForeground(Color.gray);
    }//GEN-LAST:event_BackKeyMouseEntered

    private void BackKeyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackKeyMouseExited
        // TODO add your handling code here:
        BackKey.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_BackKeyMouseExited

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x-mouseX, y-mouseY);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void RankButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RankButtonActionPerformed
        // TODO add your handling code here:
        Rank_2 rank = new Rank_2();
        rank.setVisible(true);
    }//GEN-LAST:event_RankButtonActionPerformed

    private void GameExplainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameExplainActionPerformed
        // TODO add your handling code here:
        RSPExplain explain = new RSPExplain();
        explain.setVisible(true);
    }//GEN-LAST:event_GameExplainActionPerformed

    private void gameStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameStartButtonActionPerformed
        // TODO add your handling code here:
        gameStartButton.setVisible(false);
        gameStart();
    }//GEN-LAST:event_gameStartButtonActionPerformed
    public void restart() {
        t.cancel();
        gameTimer.cancel();
        RockScissorPaper ng = new RockScissorPaper();
        ng.setVisible(true);
        this.dispose();
    }
    private void RestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartActionPerformed
        // TODO add your handling code here:
        // Game 화면 생성
        restart();
    }//GEN-LAST:event_RestartActionPerformed
    public void NumButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
                System.out.println(StartNum);
                System.out.println("값 맞음");
                System.out.println(buttons[ButtonX].getBorder().equals(idBorder));
                if(buttons[ButtonX].getBorder().equals(idBorder)) {
                    buttons[ButtonX].setBorder(idBorder2);
                    System.out.println("진짜");
                } else {
                    buttons[ButtonX].setBorder(idBorder);
                    System.out.println("가짜");
                }
                StartNum++;
                buttons[ButtonX].setText(String.valueOf(rsp[count2]));
                buttons[ButtonX].setBackground(Color.white);
              

                InputButtonValue.setVisible(true);
                InputButtonValue.setText(StartNum + "를 누르세요");
                check();
                countNum();
                shuffle();
               intToString();
              //  System.out.println("카운트");
            
        }
    private void countNum() {
        if(StartNum == 4) {
            StartNum = 1;
        }
        if(count2<2) {
          count2++; 
        } else {
            count = 0;
        }
    }
    private void intToString() {
        for(int i=0;i<3;i++) {
            if(buttons[i].getText().equals("1")) {
                buttons[i].setText("가위");
            } else if (buttons[i].getText().equals("2")) {
                 buttons[i].setText("바위");
            } else {
                buttons[i].setText("보");
            }
        }
        
        for(int i=0;i<3;i++) {
            if(rspint[i] == 1) {
                InputButtonValue.setText("이기세요");
            } else if (rspint[i] == 2) {
                 InputButtonValue.setText("지세요");
            } else {
                InputButtonValue.setText("비기세요");
            }
        }
    }
    public void check() {
        if(StartNum == 51) {
            win();
        }
    }
    private void getUserInfo() {
        Login login = new Login();
        name = login.getNick();
        NickNameLabel.setText(name + "님 반갑습니다! ");
        getPoint(); // point 불러오기
        getRank(); // 랭크 불러오기
    }
    private void gameStart() {
         CountDown();
         
    }
    private void CountDown () {
          CountNum.setVisible(true);
          CountDownTasker cd = new CountDownTasker();
          t.scheduleAtFixedRate(cd, 1000, 1000);
      
                 
    }
    public String getCurrentTimer() {
        return this.currentPoint2;
    }
    public void setCurrentTimer(String timer) {
        this.currentPoint2 = timer;
    }
    private void gameTimer () {      
          gameTimerCount gtc = new gameTimerCount();
          gameTimer.scheduleAtFixedRate(gtc, 0, 1000);
                       
    }
     class gameTimerCount extends TimerTask {

        @Override
        public void run() {
        currentTime =  System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("mm분 ss초");
        realTime = currentTime - oldTime;
        sqlSaveRealTime = (int) realTime / 1000;
        str = dayTime.format(new Date(realTime));
        System.out.println(realTime);
        TimerLabel.setText(String.valueOf(str));  
        }
        
    }
    class CountDownTasker extends TimerTask {

        @Override
        public void run() {
            if(Integer.parseInt(CountNum.getText()) >1) {
                int a = Integer.parseInt(CountNum.getText()) -1;
                CountNum.setText(Integer.toString(a));
                repaint();
            } else {
              CountNum.setVisible(false);              
              t.cancel(); // 타이머 종료
              TimerLabel.setVisible(true); // 우측 상단 타이머 표시
              InputButtonValue.setVisible(true);
              makeMap(); // 맵을 불러옴
            }
        }
        
    }
    private void makeMap() {
        // Game 화면 생성
        oldTime = System.currentTimeMillis();      
        GamePanel.setLayout(new GridLayout(3,1));
        gameTimer(); // 게임 타이머 가동
        for(int i=0; i<rsp.length;i++) {  //가위 바위 보 중복없이 버튼에 넣기
         int temp = r.nextInt(3)+1;
         rsp[i] = temp;
         for(int j=0;j<i;j++) {
             if(rsp[i] == rsp[j]) {
             i--;  // 동일한 값이 나오면 다시 
             }
         }             
        }
        
        for(int i=0; i<rspint.length;i++) {
         int temp2 = r.nextInt(3)+1;
         rspint[i] = temp2;
        }
        
     
        
        
        for(int i=0;i<3;i++) {
            int tempI = i;  
                buttons[i] = new JButton("");
                GamePanel.add(buttons[i]);
                buttons[i].setFont(new Font("굴림",Font.BOLD,15));
                buttons[i].setBorder(idBorder2);
                buttons[i].setBackground(Color.white);
                buttons[i].setText(String.valueOf(rsp[i]));          
                buttons[i].addActionListener(new java.awt.event.ActionListener() { // 액션 리스너
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                  ButtonX = tempI;
                 NumButtonActionPerformed(evt); 
                 
                }
            });
                count++;  
                }
          intToString(); 
    }
    private void win() {
    System.out.println("승리");
    gameTimer.cancel();
    getRank();
    if(name!="게스트" && (sqlSaveRealTime < Integer.parseInt(currentPoint))) {
       updateRank(); // 최고기록 갱신
       System.out.println("최고 기록 갱신");
       BestRecord bt = new BestRecord();
       bt.setVisible(true);
    } else {
        if(name!="게스트") {
           System.out.println("최고 기록을 갱신 못하셨습니다");
           updatePoint();
           setCurrentTimer(str);
           System.out.println(str);
           NotRecord not = new NotRecord();
           not.setVisible(true);
        } else {
        System.out.println("게스트는 랭킹 등록 불가");
        setCurrentTimer(str);
        GuestRecord guestWin = new GuestRecord();
        guestWin.setVisible(true);
        }
    }
            }
    private void shuffle() {
       for(int i=0; i<rsp.length;i++) {  //가위 바위 보 순서 바꾸기
         int temp = r.nextInt(3)+1;
         rsp[i] = temp;
         for(int j=0;j<i;j++) {
             if(rsp[i] == rsp[j]) {
             i--;  // 동일한 값이 나오면 다시 
             }
         }
      }      
        for(int i=0;i<3;i++) {
             buttons[i].setText(String.valueOf(rsp[i])); // 버튼에 가위 바위 보 넣기
    }
        for(int i=0; i<rspint.length;i++) {
         int temp2 = r.nextInt(3)+1;
         rspint[i] = temp2;
        }
    }
    private void updateRank() {
        PreparedStatement st , st2 ,st3;
        ResultSet rs;
        Time = TimerLabel.getText();
        System.out.println(Time);
        String query = "UPDATE `users` SET `1TO50point`=? WHERE `nickname`=?"; // 랭킹 갱신
        String query2 = "UPDATE `users` SET `point`=`point`+100 WHERE `nickname`=?"; // 포인트 추가
        String query3 = "UPDATE `users` SET `1TO50value`=? WHERE `nickname`=?"; // 비교하기 쉽게 랭킹(타이머) int 값으로 저장
        try {
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, String.valueOf(Time));
            st.setString(2, name);
            st2 = My_CNX.getConnection().prepareStatement(query2);
            st2.setString(1, name);
            st3 = My_CNX.getConnection().prepareStatement(query3);
            st3.setString(1, String.valueOf(sqlSaveRealTime));
            st3.setString(2, name);
            if(st.executeUpdate()!=0) { // 랭킹 갱신
            }
            if(st2.executeUpdate()!=0) { // 포인트 보상
                getPoint(); // point 최신화
            }
            if(st3.executeUpdate()!=0) { // 점수 int 값으로
             
            }
        }
           catch (SQLException ex) {
                
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void updatePoint() {
        PreparedStatement st;
        ResultSet rs;
        String query = "UPDATE `users` SET `point`=`point`+50 WHERE `nickname`=?"; // 포인트 추가
        try {
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, name);
            if(st.executeUpdate()!=0) {
            //     Nick = nickname;
                getPoint(); // point 최신화
            }
        }
           catch (SQLException ex) {
                
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public String getTime() {
        return this.Time = Time;
    }
    public void getRank() {
        PreparedStatement st;
        ResultSet rs;
        
        String query = "SELECT `nickname` ,`1TO50value` FROM `users` WHERE `nickname`=? AND `1TO50value` IS NOT NULL";
        
        try {
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, name);
            rs = st.executeQuery();
            
            if(rs.next()) {
                currentPoint = rs.getString("1TO50value");
                System.out.println("전적 불러오기 완료");
            } else {
                if(name != "게스트") {
                 System.out.println("존재하는 전적이 없습니다");
                 currentPoint = "1000000";
                } else {
                currentPoint = "게스트 모드";
                }
            }
        }
                catch (SQLException ex) {
                
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void getPoint() {
        PreparedStatement st;
        ResultSet rs;
        
        String query = "SELECT `nickname` ,`point` FROM `users` WHERE `nickname`=?";
        
        try {
            st = My_CNX.getConnection().prepareStatement(query);
            st.setString(1, name);
            rs = st.executeQuery();
            
            if(rs.next()) {
                point = rs.getString("point");
                System.out.println("포인트 불러오기 완료");
                pointLabel.setText("보유 IQ : " + point);
            } else { 
                if(name == "게스트") {
                    pointLabel.setText("게스트 모드");
                }
            }
        }
                catch (SQLException ex) {
                
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public String getBestTime() {
     return this.currentPoint = currentPoint;
     }
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RockScissorPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RockScissorPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RockScissorPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RockScissorPaper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RockScissorPaper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackKey;
    private javax.swing.JLabel Close;
    private javax.swing.JLabel CountNum;
    private javax.swing.JButton GameExplain;
    private javax.swing.JPanel GameLabelPanel;
    private javax.swing.JLabel GameName;
    private javax.swing.JPanel GamePanel;
    private javax.swing.JLabel InputButtonValue;
    private javax.swing.JLabel Minimize;
    private javax.swing.JLabel NickNameLabel;
    private javax.swing.JButton RankButton;
    private javax.swing.JButton Restart;
    private javax.swing.JLabel TimerLabel;
    private javax.swing.JButton gameStartButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel pointLabel;
    // End of variables declaration//GEN-END:variables
}
