/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.io.*;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author Rebecca Plourde
 * 
 * questions from:
 * http://www.quiz-questions.net/index.html
 * 
 */

public class Trivia extends javax.swing.JFrame {
    
    private Timer t;
    private Timer t2;
    private int timerCount = 0;
    private int wCount = 0;
    private int[] roundScore = new int[15];
    private boolean[] currentQScore = new boolean[15];
    private int[] totalScore = new int[15];
    private JLabel[] rScore = new JLabel[15];
    private JLabel[] tScore = new JLabel[15];
    private String[][] questions = new String[10000][3];
    private String[] categories = new String[1000];
    private int[] usedQs = new int[20];
    private int[] usedCs = new int[5];
    private int[] chooseC = new int[4];
    private int[] chooseQ = new int[20];
    
    
    private int first = 0;
    private int second = 1;
    private int third = 2;
    private int numCategories = 0;
    private int numQuestions = 0;
    private int roundCount = 0;
    private int totalQCount = 0;
    private int catCount = 0;
    private int tCounts = 0;
    int rndQ;
    int randCat;
    Random c = new Random();
    Random q = new Random();
    

    /**
     * Creates new form Trivia
     */
    public Trivia() {
        initComponents();
        loadJLabels();
        instantiateArrays();
        readFile();
        
    }
    
    public void readFile(){
        
        submitQuestionScore.setVisible(false);
        jButton4.setVisible(false);
        clearTeams.setVisible(false);
        revealAnswer.setVisible(false);
        nextQuestion.setVisible(false);
        String line = " ";
        String temp = "";
        int start = 0;
        int count = 0;
        try
                {
                    Scanner reader = new Scanner(new File("trivia_questions.csv"));
                    
                    String currLine = " ";
                    
                   while (reader.hasNext())
                    {
                        
                        currLine = reader.nextLine().trim();
                        line = currLine +"\n";
                        
                        for (int i = 0; i < currLine.length(); i++){
                            String c = String.valueOf(currLine.charAt(i));
                            
                            
            
                            if(c.equals(","))
                            {
                                
                                temp = line.substring(start, i);
                                questions[numQuestions][count] = temp;
                                
                                
                                if(count == 0){
                                    if(numCategories == 0){
                                        categories[numCategories]= temp;
                                        numCategories++;
                                    }else if(numCategories > 0){
                                        boolean used = false;
                                            for(int x = 1; x <= numCategories; x++){
                                                if(temp.equalsIgnoreCase(categories[x-1]))
                                                used = true;       
                                            }
                                        if(used == false){
                                            categories[numCategories] = temp;
                                            numCategories++;
                                        }
                                    }     
                                }
                                
                                start = i + 1;
                                count++;
                                if(count == 2){
                                    questions[numQuestions][count] = line.substring(i+1,currLine.length());
                                    count = 0;
                                    numQuestions++;
                                    start = 0;
                                    
                                }
                                
                            }
                        }
                    }
                    
                    reader.close();
                }
                catch (Exception e)
                {
                    System.err.format("Exception occurred trying to read '%s'.", "TestData.java");
                    e.printStackTrace();
                }

    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Scores = new javax.swing.JTabbedPane();
        Home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Teams = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        submitTeams = new javax.swing.JButton();
        Team1 = new javax.swing.JTextField();
        Team2 = new javax.swing.JTextField();
        Team3 = new javax.swing.JTextField();
        Team4 = new javax.swing.JTextField();
        Team5 = new javax.swing.JTextField();
        Team6 = new javax.swing.JTextField();
        Team7 = new javax.swing.JTextField();
        Team8 = new javax.swing.JTextField();
        Team10 = new javax.swing.JTextField();
        Team9 = new javax.swing.JTextField();
        Team13 = new javax.swing.JTextField();
        Team12 = new javax.swing.JTextField();
        Team11 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        clearTeams = new javax.swing.JButton();
        tn1 = new javax.swing.JLabel();
        tn2 = new javax.swing.JLabel();
        tn4 = new javax.swing.JLabel();
        tn3 = new javax.swing.JLabel();
        tn6 = new javax.swing.JLabel();
        tn5 = new javax.swing.JLabel();
        tn7 = new javax.swing.JLabel();
        tn8 = new javax.swing.JLabel();
        tn10 = new javax.swing.JLabel();
        tn9 = new javax.swing.JLabel();
        tn11 = new javax.swing.JLabel();
        tn13 = new javax.swing.JLabel();
        tn12 = new javax.swing.JLabel();
        Team14 = new javax.swing.JTextField();
        Team15 = new javax.swing.JTextField();
        tn15 = new javax.swing.JLabel();
        tn14 = new javax.swing.JLabel();
        Game = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        timer1 = new javax.swing.JLabel();
        timer2 = new javax.swing.JLabel();
        CatName = new javax.swing.JLabel();
        qNum = new javax.swing.JLabel();
        roundNum = new javax.swing.JLabel();
        newGame = new javax.swing.JButton();
        nextQuestion = new javax.swing.JButton();
        revealAnswer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        Score = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        submitQuestionScore = new javax.swing.JButton();
        one = new javax.swing.JLabel();
        two = new javax.swing.JLabel();
        three = new javax.swing.JLabel();
        four = new javax.swing.JLabel();
        five = new javax.swing.JLabel();
        six = new javax.swing.JLabel();
        seven = new javax.swing.JLabel();
        eight = new javax.swing.JLabel();
        nine = new javax.swing.JLabel();
        ten = new javax.swing.JLabel();
        eleven = new javax.swing.JLabel();
        twelve = new javax.swing.JLabel();
        thirteen = new javax.swing.JLabel();
        tot1 = new javax.swing.JLabel();
        tot2 = new javax.swing.JLabel();
        tot3 = new javax.swing.JLabel();
        tot4 = new javax.swing.JLabel();
        tot5 = new javax.swing.JLabel();
        tot6 = new javax.swing.JLabel();
        tot7 = new javax.swing.JLabel();
        tot8 = new javax.swing.JLabel();
        tot9 = new javax.swing.JLabel();
        tot10 = new javax.swing.JLabel();
        tot11 = new javax.swing.JLabel();
        tot12 = new javax.swing.JLabel();
        tot13 = new javax.swing.JLabel();
        rsNum = new javax.swing.JLabel();
        fourteen = new javax.swing.JLabel();
        fifteen = new javax.swing.JLabel();
        tot14 = new javax.swing.JLabel();
        tot15 = new javax.swing.JLabel();
        r1 = new javax.swing.JLabel();
        r2 = new javax.swing.JLabel();
        r3 = new javax.swing.JLabel();
        r4 = new javax.swing.JLabel();
        r5 = new javax.swing.JLabel();
        r6 = new javax.swing.JLabel();
        r7 = new javax.swing.JLabel();
        r8 = new javax.swing.JLabel();
        r9 = new javax.swing.JLabel();
        r10 = new javax.swing.JLabel();
        r11 = new javax.swing.JLabel();
        r12 = new javax.swing.JLabel();
        r13 = new javax.swing.JLabel();
        r14 = new javax.swing.JLabel();
        r15 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        checkbox2 = new java.awt.Checkbox();
        checkbox1 = new java.awt.Checkbox();
        checkbox3 = new java.awt.Checkbox();
        checkbox4 = new java.awt.Checkbox();
        checkbox5 = new java.awt.Checkbox();
        checkbox6 = new java.awt.Checkbox();
        checkbox7 = new java.awt.Checkbox();
        checkbox9 = new java.awt.Checkbox();
        checkbox8 = new java.awt.Checkbox();
        checkbox10 = new java.awt.Checkbox();
        checkbox12 = new java.awt.Checkbox();
        checkbox11 = new java.awt.Checkbox();
        checkbox13 = new java.awt.Checkbox();
        checkbox14 = new java.awt.Checkbox();
        checkbox15 = new java.awt.Checkbox();
        jLabel28 = new javax.swing.JLabel();
        qn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Scores.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Home.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tony.000.logo.jpg"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("created by: Rebecca Plourde");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TUESDAY NIGHTS @ 7:00 PM");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JohnstonGC10.jpg"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JohnstonGC20.jpg"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JohnstonGC30.jpg"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 32)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("POSSIBLE PRIZES:");

        jLabel14.setFont(new java.awt.Font("Tempus Sans ITC", 1, 32)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("44 PUTNAM PIKE JOHNSTON, RI");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        Scores.addTab("Home", Home);

        Teams.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));
        jLabel8.setText("Team Names:");

        submitTeams.setBackground(new java.awt.Color(204, 0, 0));
        submitTeams.setText("Submit Team Names");
        submitTeams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitTeamsActionPerformed(evt);
            }
        });

        Team1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team1.setForeground(new java.awt.Color(204, 0, 0));

        Team2.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team2.setForeground(new java.awt.Color(204, 0, 0));

        Team3.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team3.setForeground(new java.awt.Color(204, 0, 0));
        Team3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Team3ActionPerformed(evt);
            }
        });

        Team4.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team4.setForeground(new java.awt.Color(204, 0, 0));

        Team5.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team5.setForeground(new java.awt.Color(204, 0, 0));

        Team6.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team6.setForeground(new java.awt.Color(204, 0, 0));

        Team7.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team7.setForeground(new java.awt.Color(204, 0, 0));

        Team8.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team8.setForeground(new java.awt.Color(204, 0, 0));
        Team8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Team8ActionPerformed(evt);
            }
        });

        Team10.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team10.setForeground(new java.awt.Color(204, 0, 0));
        Team10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Team10ActionPerformed(evt);
            }
        });

        Team9.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team9.setForeground(new java.awt.Color(204, 0, 0));
        Team9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Team9ActionPerformed(evt);
            }
        });

        Team13.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team13.setForeground(new java.awt.Color(204, 0, 0));

        Team12.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team12.setForeground(new java.awt.Color(204, 0, 0));

        Team11.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team11.setForeground(new java.awt.Color(204, 0, 0));

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 0));
        jLabel9.setText("Enter Team Names:");

        clearTeams.setBackground(new java.awt.Color(204, 0, 0));
        clearTeams.setText("Clear Team Names");
        clearTeams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTeamsActionPerformed(evt);
            }
        });

        tn1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn1.setForeground(new java.awt.Color(204, 0, 0));

        tn2.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn2.setForeground(new java.awt.Color(204, 0, 0));

        tn4.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn4.setForeground(new java.awt.Color(204, 0, 0));

        tn3.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn3.setForeground(new java.awt.Color(204, 0, 0));

        tn6.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn6.setForeground(new java.awt.Color(204, 0, 0));

        tn5.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn5.setForeground(new java.awt.Color(204, 0, 0));

        tn7.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn7.setForeground(new java.awt.Color(204, 0, 0));

        tn8.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn8.setForeground(new java.awt.Color(204, 0, 0));

        tn10.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn10.setForeground(new java.awt.Color(204, 0, 0));

        tn9.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn9.setForeground(new java.awt.Color(204, 0, 0));

        tn11.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn11.setForeground(new java.awt.Color(204, 0, 0));

        tn13.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn13.setForeground(new java.awt.Color(204, 0, 0));

        tn12.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn12.setForeground(new java.awt.Color(204, 0, 0));

        Team14.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team14.setForeground(new java.awt.Color(204, 0, 0));
        Team14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Team14ActionPerformed(evt);
            }
        });

        Team15.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        Team15.setForeground(new java.awt.Color(204, 0, 0));

        tn15.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn15.setForeground(new java.awt.Color(204, 0, 0));

        tn14.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tn14.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout TeamsLayout = new javax.swing.GroupLayout(Teams);
        Teams.setLayout(TeamsLayout);
        TeamsLayout.setHorizontalGroup(
            TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeamsLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(submitTeams)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearTeams)
                .addGap(157, 157, 157))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeamsLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Team15)
                    .addComponent(Team1)
                    .addComponent(Team13)
                    .addComponent(Team12)
                    .addComponent(Team11)
                    .addComponent(Team10)
                    .addComponent(Team9)
                    .addComponent(Team8)
                    .addComponent(Team7)
                    .addComponent(Team6)
                    .addComponent(Team5)
                    .addComponent(Team4)
                    .addComponent(Team3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Team2)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Team14, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tn1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn13, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn12, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn11, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn10, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn15, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn14, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(211, 211, 211))
        );
        TeamsLayout.setVerticalGroup(
            TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeamsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Team15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(TeamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitTeams)
                    .addComponent(clearTeams))
                .addContainerGap())
        );

        Scores.addTab("Teams", Teams);

        Game.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 0));
        jLabel15.setText("Round:");

        jLabel16.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 0));
        jLabel16.setText("Category:");

        jLabel17.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 0));
        jLabel17.setText("Question:");

        jLabel18.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("TIMER:");

        jLabel19.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("TIMER:");

        timer1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 100)); // NOI18N
        timer1.setForeground(new java.awt.Color(204, 0, 0));
        timer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer1.setText("120");

        timer2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 100)); // NOI18N
        timer2.setForeground(new java.awt.Color(204, 0, 0));
        timer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer2.setText("120");

        CatName.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        CatName.setForeground(new java.awt.Color(204, 0, 0));

        qNum.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        qNum.setForeground(new java.awt.Color(204, 0, 0));

        roundNum.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        roundNum.setForeground(new java.awt.Color(204, 0, 0));

        newGame.setBackground(new java.awt.Color(204, 0, 0));
        newGame.setText("New Game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });

        nextQuestion.setBackground(new java.awt.Color(204, 0, 0));
        nextQuestion.setText("Next Question");
        nextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionActionPerformed(evt);
            }
        });

        revealAnswer.setBackground(new java.awt.Color(204, 0, 0));
        revealAnswer.setText("Reveal Answer");
        revealAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revealAnswerActionPerformed(evt);
            }
        });

        question.setColumns(20);
        question.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        question.setForeground(new java.awt.Color(204, 0, 0));
        question.setLineWrap(true);
        question.setRows(5);
        question.setWrapStyleWord(true);
        jScrollPane1.setViewportView(question);

        javax.swing.GroupLayout GameLayout = new javax.swing.GroupLayout(Game);
        Game.setLayout(GameLayout);
        GameLayout.setHorizontalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GameLayout.createSequentialGroup()
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timer1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(GameLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newGame, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(revealAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                                .addComponent(timer2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GameLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roundNum, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(215, 215, 215)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CatName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(qNum, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))))
        );
        GameLayout.setVerticalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(CatName)
                    .addComponent(qNum)
                    .addComponent(roundNum))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GameLayout.createSequentialGroup()
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(timer2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(timer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(GameLayout.createSequentialGroup()
                        .addComponent(newGame, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(revealAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Scores.addTab("Game", Game);

        Score.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 0));
        jLabel10.setText("Team Name:");

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 0));
        jLabel11.setText("Round Score:");

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 0));
        jLabel12.setText("Total Score:");

        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 0));
        jLabel13.setText("Round");

        jButton4.setBackground(new java.awt.Color(204, 0, 0));
        jButton4.setText("Redo Question Score");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        submitQuestionScore.setBackground(new java.awt.Color(204, 0, 0));
        submitQuestionScore.setText("Submit Question Score");
        submitQuestionScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitQuestionScoreActionPerformed(evt);
            }
        });

        one.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        one.setForeground(new java.awt.Color(204, 0, 0));
        one.setText("Team One");

        two.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        two.setForeground(new java.awt.Color(204, 0, 0));
        two.setText("Team Two");

        three.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        three.setForeground(new java.awt.Color(204, 0, 0));
        three.setText("Team Three");

        four.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        four.setForeground(new java.awt.Color(204, 0, 0));
        four.setText("Team Four");

        five.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        five.setForeground(new java.awt.Color(204, 0, 0));
        five.setText("Team Five");

        six.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        six.setForeground(new java.awt.Color(204, 0, 0));
        six.setText("Team Six");

        seven.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        seven.setForeground(new java.awt.Color(204, 0, 0));
        seven.setText("Team Seven");

        eight.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        eight.setForeground(new java.awt.Color(204, 0, 0));
        eight.setText("Team Eight");

        nine.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        nine.setForeground(new java.awt.Color(204, 0, 0));
        nine.setText("Team Nine");

        ten.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        ten.setForeground(new java.awt.Color(204, 0, 0));
        ten.setText("Team Ten");

        eleven.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        eleven.setForeground(new java.awt.Color(204, 0, 0));
        eleven.setText("Team Eleven");

        twelve.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        twelve.setForeground(new java.awt.Color(204, 0, 0));
        twelve.setText("Team Twelve");

        thirteen.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        thirteen.setForeground(new java.awt.Color(204, 0, 0));
        thirteen.setText("Team Thirteen");

        tot1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot1.setForeground(new java.awt.Color(204, 0, 0));

        tot2.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot2.setForeground(new java.awt.Color(204, 0, 0));

        tot3.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot3.setForeground(new java.awt.Color(204, 0, 0));

        tot4.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot4.setForeground(new java.awt.Color(204, 0, 0));

        tot5.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot5.setForeground(new java.awt.Color(204, 0, 0));

        tot6.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot6.setForeground(new java.awt.Color(204, 0, 0));

        tot7.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot7.setForeground(new java.awt.Color(204, 0, 0));

        tot8.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot8.setForeground(new java.awt.Color(204, 0, 0));

        tot9.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot9.setForeground(new java.awt.Color(204, 0, 0));

        tot10.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot10.setForeground(new java.awt.Color(204, 0, 0));

        tot11.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot11.setForeground(new java.awt.Color(204, 0, 0));

        tot12.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot12.setForeground(new java.awt.Color(204, 0, 0));

        tot13.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot13.setForeground(new java.awt.Color(204, 0, 0));

        rsNum.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        rsNum.setForeground(new java.awt.Color(204, 0, 0));
        rsNum.setText("1");

        fourteen.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        fourteen.setForeground(new java.awt.Color(204, 0, 0));
        fourteen.setText("Team Fourteen");

        fifteen.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        fifteen.setForeground(new java.awt.Color(204, 0, 0));
        fifteen.setText("Team Fifteen");

        tot14.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot14.setForeground(new java.awt.Color(204, 0, 0));

        tot15.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        tot15.setForeground(new java.awt.Color(204, 0, 0));

        r1.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r1.setForeground(new java.awt.Color(204, 0, 0));

        r2.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r2.setForeground(new java.awt.Color(204, 0, 0));

        r3.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r3.setForeground(new java.awt.Color(204, 0, 0));

        r4.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r4.setForeground(new java.awt.Color(204, 0, 0));

        r5.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r5.setForeground(new java.awt.Color(204, 0, 0));

        r6.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r6.setForeground(new java.awt.Color(204, 0, 0));

        r7.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r7.setForeground(new java.awt.Color(204, 0, 0));

        r8.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r8.setForeground(new java.awt.Color(204, 0, 0));

        r9.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r9.setForeground(new java.awt.Color(204, 0, 0));

        r10.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r10.setForeground(new java.awt.Color(204, 0, 0));

        r11.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r11.setForeground(new java.awt.Color(204, 0, 0));

        r12.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r12.setForeground(new java.awt.Color(204, 0, 0));

        r13.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r13.setForeground(new java.awt.Color(204, 0, 0));

        r14.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r14.setForeground(new java.awt.Color(204, 0, 0));

        r15.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        r15.setForeground(new java.awt.Color(204, 0, 0));

        jLabel27.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 0));
        jLabel27.setText("Question Score (Check if Correct):");

        checkbox2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox2.setForeground(new java.awt.Color(204, 0, 0));
        checkbox2.setLabel("Team Name");

        checkbox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox1.setForeground(new java.awt.Color(204, 0, 0));
        checkbox1.setLabel("Team Name");

        checkbox3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox3.setForeground(new java.awt.Color(204, 0, 0));
        checkbox3.setLabel("Team Name");

        checkbox4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox4.setForeground(new java.awt.Color(204, 0, 0));
        checkbox4.setLabel("Team Name");

        checkbox5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox5.setForeground(new java.awt.Color(204, 0, 0));
        checkbox5.setLabel("Team Name");

        checkbox6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox6.setForeground(new java.awt.Color(204, 0, 0));
        checkbox6.setLabel("Team Name");

        checkbox7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox7.setForeground(new java.awt.Color(204, 0, 0));
        checkbox7.setLabel("Team Name");

        checkbox9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox9.setForeground(new java.awt.Color(204, 0, 0));
        checkbox9.setLabel("Team Name");

        checkbox8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox8.setForeground(new java.awt.Color(204, 0, 0));
        checkbox8.setLabel("Team Name");

        checkbox10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox10.setForeground(new java.awt.Color(204, 0, 0));
        checkbox10.setLabel("Team Name");

        checkbox12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox12.setForeground(new java.awt.Color(204, 0, 0));
        checkbox12.setLabel("Team Name");

        checkbox11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox11.setForeground(new java.awt.Color(204, 0, 0));
        checkbox11.setLabel("Team Name");

        checkbox13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox13.setForeground(new java.awt.Color(204, 0, 0));
        checkbox13.setLabel("Team Name");

        checkbox14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox14.setForeground(new java.awt.Color(204, 0, 0));
        checkbox14.setLabel("Team Name");

        checkbox15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkbox15.setForeground(new java.awt.Color(204, 0, 0));
        checkbox15.setLabel("Team Name");

        jLabel28.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 0));
        jLabel28.setText("Question:");

        qn.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        qn.setForeground(new java.awt.Color(204, 0, 0));
        qn.setText("1");

        javax.swing.GroupLayout ScoreLayout = new javax.swing.GroupLayout(Score);
        Score.setLayout(ScoreLayout);
        ScoreLayout.setHorizontalGroup(
            ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScoreLayout.createSequentialGroup()
                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ScoreLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ScoreLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(113, 113, 113)
                                .addComponent(jLabel27))
                            .addGroup(ScoreLayout.createSequentialGroup()
                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(twelve, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eleven, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(167, 167, 167)
                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE))
                    .addGroup(ScoreLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(submitQuestionScore)
                        .addGap(204, 204, 204)))
                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r12, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r11, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r10, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4))
                .addGap(86, 86, 86)
                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel12)
                                                            .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(tot1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(tot4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(tot3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(tot2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(ScoreLayout.createSequentialGroup()
                                                                    .addComponent(jLabel13)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(rsNum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addComponent(tot14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(tot15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(tot11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(tot10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tot13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(tot12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tot9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tot8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tot7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tot6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tot5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        ScoreLayout.setVerticalGroup(
            ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ScoreLayout.createSequentialGroup()
                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tot1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tot2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tot3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tot4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tot10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tot11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(ScoreLayout.createSequentialGroup()
                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ScoreLayout.createSequentialGroup()
                                .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ScoreLayout.createSequentialGroup()
                                        .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ScoreLayout.createSequentialGroup()
                                                .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(ScoreLayout.createSequentialGroup()
                                                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(ScoreLayout.createSequentialGroup()
                                                                .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(ScoreLayout.createSequentialGroup()
                                                                        .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addGroup(ScoreLayout.createSequentialGroup()
                                                                                .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addGroup(ScoreLayout.createSequentialGroup()
                                                                                        .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                            .addGroup(ScoreLayout.createSequentialGroup()
                                                                                                .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                    .addGroup(ScoreLayout.createSequentialGroup()
                                                                                                        .addComponent(eleven, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                            .addGroup(ScoreLayout.createSequentialGroup()
                                                                                                                .addComponent(twelve, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                    .addComponent(thirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                    .addComponent(checkbox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                            .addComponent(checkbox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                    .addComponent(checkbox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                            .addComponent(checkbox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                    .addComponent(checkbox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                            .addComponent(checkbox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                    .addComponent(checkbox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addComponent(checkbox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(checkbox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(checkbox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScoreLayout.createSequentialGroup()
                                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(ScoreLayout.createSequentialGroup()
                                                        .addComponent(r5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(12, 12, 12))
                                                    .addComponent(tot5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(ScoreLayout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addComponent(tot6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(12, 12, 12)
                                                        .addComponent(tot7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(tot8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(tot9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(89, 89, 89)
                                                        .addComponent(tot12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(tot13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(ScoreLayout.createSequentialGroup()
                                                        .addComponent(r6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(r7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(13, 13, 13)
                                                        .addComponent(r8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(r9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(r10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(r11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(r12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(9, 9, 9)
                                                        .addComponent(r13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(2, 2, 2))))
                                    .addComponent(checkbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(checkbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tot14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkbox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tot15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(checkbox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(qn)
                        .addComponent(submitQuestionScore))
                    .addGroup(ScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(rsNum)
                        .addComponent(jButton4)))
                .addContainerGap())
        );

        Scores.addTab("Scores", Score);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Scores)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Scores, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Team10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Team10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Team10ActionPerformed

    private void Team8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Team8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Team8ActionPerformed

    private void Team9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Team9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Team9ActionPerformed

    private void Team14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Team14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Team14ActionPerformed

    private void submitTeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitTeamsActionPerformed
        submitTeams.setVisible(false);
        clearTeams.setVisible(true);
        tn1.setText(Team1.getText());
        tn2.setText(Team2.getText());
        tn3.setText(Team3.getText());
        tn4.setText(Team4.getText());
        tn5.setText(Team5.getText());
        tn6.setText(Team6.getText());
        tn7.setText(Team7.getText());
        tn8.setText(Team8.getText());
        tn9.setText(Team9.getText());
        tn10.setText(Team10.getText());
        tn11.setText(Team11.getText());
        tn12.setText(Team12.getText());
        tn13.setText(Team13.getText());
        tn14.setText(Team14.getText());
        tn15.setText(Team15.getText());
        
        one.setText(Team1.getText());
        two.setText(Team2.getText());
        three.setText(Team3.getText());
        four.setText(Team4.getText());
        five.setText(Team5.getText());
        six.setText(Team6.getText());
        seven.setText(Team7.getText());
        eight.setText(Team8.getText());
        nine.setText(Team9.getText());
        ten.setText(Team10.getText());
        eleven.setText(Team11.getText());
        twelve.setText(Team12.getText());
        thirteen.setText(Team13.getText());
        fourteen.setText(Team14.getText());
        fifteen.setText(Team15.getText());
        
        checkbox1.setLabel(Team1.getText());
        checkbox2.setLabel(Team2.getText());
        checkbox3.setLabel(Team3.getText());
        checkbox4.setLabel(Team4.getText());
        checkbox5.setLabel(Team5.getText());
        checkbox6.setLabel(Team6.getText());
        checkbox7.setLabel(Team7.getText());
        checkbox8.setLabel(Team8.getText());
        checkbox9.setLabel(Team9.getText());
        checkbox10.setLabel(Team10.getText());
        checkbox11.setLabel(Team11.getText());
        checkbox12.setLabel(Team12.getText());
        checkbox13.setLabel(Team13.getText());
        checkbox14.setLabel(Team14.getText());
        checkbox15.setLabel(Team15.getText());
        
    }//GEN-LAST:event_submitTeamsActionPerformed

    private void Team3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Team3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Team3ActionPerformed

    private void revealAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revealAnswerActionPerformed
        nextQuestion.setVisible(true);
        revealAnswer.setVisible(false);
        if(totalQCount > 0)
            t.stop();
        revealAnswer();
    }//GEN-LAST:event_revealAnswerActionPerformed

    private void submitQuestionScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitQuestionScoreActionPerformed
        submitQuestionScore.setVisible(false);
        jButton4.setVisible(true);
        if (checkbox1.getState()){
            if(totalQCount < 16){
                roundScore[0]+= 2;
                totalScore[0]+= 2;
            }else{
                roundScore[0]+= 5;
                totalScore[0]+= 5;
            }
            currentQScore[0] = true;
        }else{
            currentQScore[0] = false;
        }
        if (checkbox2.getState()){
            if(totalQCount < 16){
                roundScore[1]+= 2;
                totalScore[1]+= 2;
            }else{
                roundScore[1]+= 5;
                totalScore[1]+= 5;
            }
            currentQScore[1] = true;
        }else
            currentQScore[1] = false;
        if (checkbox3.getState()){
            if(totalQCount < 16){
                roundScore[2]+= 2;
                totalScore[2]+= 2;
            }else{
                roundScore[2]+= 5;
                totalScore[2]+= 5;
            }
            currentQScore[2] = true;
        }else
            currentQScore[2] = false;
        if (checkbox4.getState()){
            if(totalQCount < 16){
                roundScore[3]+= 2;
                totalScore[3]+= 2;
            }else{
                roundScore[3]+= 5;
                totalScore[3]+= 5;
            }
            currentQScore[3] = true;
        }else
            currentQScore[3] = false;
        if (checkbox5.getState()){
            if(totalQCount < 16){
                roundScore[4]+= 2;
                totalScore[4]+= 2;
            }else{
                roundScore[4]+= 5;
                totalScore[4]+= 5;
            }
            currentQScore[4] = true;
        }else
            currentQScore[4] = false;
        if (checkbox6.getState()){
            if(totalQCount < 16){
                roundScore[5]+= 2;
                totalScore[5]+= 2;
            }else{
                roundScore[5]+= 5;
                totalScore[5]+= 5;
            }
            currentQScore[5] = true;
        }else
            currentQScore[5] = false;
        if (checkbox7.getState()){
            if(totalQCount < 16){
                roundScore[6]+= 2;
                totalScore[6]+= 2;
            }else{
                roundScore[6]+= 5;
                totalScore[6]+= 5;
            }
            currentQScore[6] = true;
        }else
            currentQScore[6] = false;
        if (checkbox8.getState()){
            if(totalQCount < 16){
                roundScore[7]+= 2;
                totalScore[7]+= 2;
            }else{
                roundScore[7]+= 5;
                totalScore[7]+= 5;
            }
            currentQScore[7] = true;
        }else
            currentQScore[7] = false;
        if (checkbox9.getState()){
            if(totalQCount < 16){
                roundScore[8]+= 2;
                totalScore[8]+= 2;
            }else{
                roundScore[8]+= 5;
                totalScore[8]+= 5;
            }
            currentQScore[8] = true;
        }else
            currentQScore[8] = false;
        if (checkbox10.getState()){
            if(totalQCount < 16){
                roundScore[9]+= 2;
                totalScore[9]+= 2;
            }else{
                roundScore[9]+= 5;
                totalScore[9]+= 5;
            }
            currentQScore[9] = true;
        }else
            currentQScore[9] = false;
        if (checkbox11.getState()){
            if(totalQCount < 16){
                roundScore[10]+= 2;
                totalScore[10]+= 2;
            }else{
                roundScore[10]+= 5;
                totalScore[10]+= 5;
            }
            currentQScore[10] = true;
        }else
            currentQScore[10] = false;
        if (checkbox12.getState()){
            if(totalQCount < 16){
                roundScore[11]+= 2;
                totalScore[11]+= 2;
            }else{
                roundScore[11]+= 5;
                totalScore[11]+= 5;
            }
            currentQScore[11] = true;
        }else
            currentQScore[11] = false;
        if (checkbox13.getState()){
            if(totalQCount < 16){
                roundScore[12]+= 2;
                totalScore[12]+= 2;
            }else{
                roundScore[12]+= 5;
                totalScore[12]+= 5;
            }
            currentQScore[12] = true;
        }else
            currentQScore[12] = false;
        if (checkbox14.getState()){
            if(totalQCount < 16){
                roundScore[13]+= 2;
                totalScore[13]+= 2;
            }else{
                roundScore[13]+= 5;
                totalScore[13]+= 5;
            }
            currentQScore[13] = true;
        }else
            currentQScore[13] = false;
        if (checkbox15.getState()){
            if(totalQCount < 16){
                roundScore[14]+= 2;
                totalScore[14]+= 2;
            }else{
                roundScore[14]+= 5;
                totalScore[14]+= 5;
            }
            currentQScore[14] = true;
        }else
            currentQScore[14] = false;
        
        updateScores();
        
    }//GEN-LAST:event_submitQuestionScoreActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        nextQuestion.setVisible(false);
        submitQuestionScore.setVisible(true);
        revealAnswer.setVisible(true);
        if(totalQCount > 0){
            t.stop();
        }
            
        newGame();
        
        startTimer();
    }//GEN-LAST:event_newGameActionPerformed

    private void nextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionActionPerformed
        revealAnswer.setVisible(true);
        submitQuestionScore.setVisible(true);
        nextQuestion.setVisible(false);
        if(totalQCount > 0)
            t.stop();
        timer1.setText("120");
        timer2.setText("120");
        startTimer();
        runGame();
        
        for(int x = 0; x < 15; x++){
                if(totalQCount == 6 || totalQCount == 11 || totalQCount == 16){
                    roundScore[x] = 0;
                    rScore[x].setText("");
                }
        }
    }//GEN-LAST:event_nextQuestionActionPerformed

    private void clearTeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTeamsActionPerformed
        submitTeams.setVisible(true);
        clearTeams.setVisible(false);
        tn1.setText("");
        tn2.setText("");
        tn3.setText("");
        tn4.setText("");
        tn5.setText("");
        tn6.setText("");
        tn7.setText("");
        tn8.setText("");
        tn9.setText("");
        tn10.setText("");
        tn11.setText("");
        tn12.setText("");
        tn13.setText("");
        tn14.setText("");
        tn15.setText("");
        
        Team1.setText("");
        Team2.setText("");
        Team3.setText("");
        Team4.setText("");
        Team5.setText("");
        Team6.setText("");
        Team7.setText("");
        Team8.setText("");
        Team9.setText("");
        Team10.setText("");
        Team11.setText("");
        Team12.setText("");
        Team13.setText("");
        Team14.setText("");
        Team15.setText("");
        
        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        six.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");
        ten.setText("");
        eleven.setText("");
        twelve.setText("");
        thirteen.setText("");
        fourteen.setText("");
        fifteen.setText("");
        
        checkbox1.setLabel("");
        checkbox2.setLabel("");
        checkbox3.setLabel("");
        checkbox4.setLabel("");
        checkbox5.setLabel("");
        checkbox6.setLabel("");
        checkbox7.setLabel("");
        checkbox8.setLabel("");
        checkbox9.setLabel("");
        checkbox10.setLabel("");
        checkbox11.setLabel("");
        checkbox12.setLabel("");
        checkbox13.setLabel("");
        checkbox14.setLabel("");
        checkbox15.setLabel("");
        
    }//GEN-LAST:event_clearTeamsActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.setVisible(false);
        submitQuestionScore.setVisible(true);
        for(int i = 0; i <15; i++){
            if(currentQScore[i]){
                if(totalQCount < 16){
                roundScore[i]-= 2;
                totalScore[i]-= 2;
                }else{
                roundScore[i]-= 5;
                totalScore[i]-= 5;
            }
                currentQScore[i]=false;
            }
        }
        
        updateScores();
    }//GEN-LAST:event_jButton4ActionPerformed

    public void newGame(){
        if(wCount > 0)
            t2.stop();
        roundCount = 1;
        catCount = 0;
        totalQCount = 0;
        
        for(int x = 0; x < 15; x++){
            roundScore[x]=0;
            totalScore[x]=0;
        }
        updateScores();
        
        int count = 0;
        roundNum.setText(Integer.toString(roundCount));
        rsNum.setText(Integer.toString(roundCount));
        
        while(count < 4){
            randCat = Math.abs(c.nextInt()) % numCategories;
                if(count == 0){
                    chooseC[count]= randCat;
                    count++;
                }else if(count == 1 && chooseC[0] != randCat){
                    chooseC[count]= randCat;
                    count++;
                }else if(count == 2 && chooseC[0] != randCat &&
                        chooseC[1] != randCat){
                    chooseC[count]= randCat;
                    count++;
                }else if(count == 3 && chooseC[0] != randCat && 
                        chooseC[1] != randCat && chooseC[2] != randCat){
                    chooseC[count]= randCat;
                    count++;
                }
            
        }

        int count2 = 0;
        int count3 = 0;

        
        CatName.setText(categories[chooseC[0]]);
        
        while(count2 < 20){
            
            if(count2 < 5)
                count3 = 0;
            else if(count2 < 10 && count2 >= 5)
                count3 = 1;
            else if(count2 < 15 && count2 >= 10)
                count3 = 2;
            else if(count2 < 20 && count2 >= 15)
                count3 = 3;
            
            boolean used = false;
            rndQ = Math.abs(q.nextInt()) % numQuestions;
            
            for(int i = 0; i < 20; i++){
                if((rndQ == chooseQ[i]))
                    used = true;       
            }
            
            if((used == false) && (questions[rndQ][0].equalsIgnoreCase(categories[chooseC[count3]]))){
                chooseQ[count2] = rndQ;
                count2++;
            }
                    
            
        }
        
       
        CatName.setText(categories[chooseC[catCount]]);
        qNum.setText(Integer.toString(totalQCount+1));
        qn.setText(Integer.toString(totalQCount+1));
                
        question.setText(questions[chooseQ[totalQCount]][1]);
        totalQCount++; 
        
    }
    
    public void revealAnswer(){
        question.setText(questions[chooseQ[totalQCount-1]][2]);
    }
    
    public String findFirst(){

    
        if(first == 0)
            return(one.getText());
        else if(first == 1)
            return(two.getText());
        else if(first == 2)
            return(three.getText());
        else if(first == 3)
            return(four.getText());
        else if(first == 4)
            return(five.getText());
        else if(first == 5)
            return(six.getText());
        else if(first == 6)
            return(seven.getText());
        else if(first == 7)
            return(eight.getText());
        else if(first == 8)
            return(nine.getText());
        else if(first == 9)
            return(ten.getText());
        else if(first == 10)
            return(eleven.getText());
        else if(first == 11)
            return(twelve.getText());
        else if(first == 12)
            return(thirteen.getText());
        else if(first == 13)
            return(fourteen.getText());
        else if(first == 14)
            return(fifteen.getText());
        else
            return("");
    
    }
    
    public String findSecond(){

    
        if(second == 0)
            return(one.getText());
        else if(second == 1)
            return(two.getText());
        else if(second == 2)
            return(three.getText());
        else if(second == 3)
            return(four.getText());
        else if(second == 4)
            return(five.getText());
        else if(second == 5)
            return(six.getText());
        else if(second == 6)
            return(seven.getText());
        else if(second == 7)
            return(eight.getText());
        else if(second == 8)
            return(nine.getText());
        else if(second == 9)
            return(ten.getText());
        else if(second == 10)
            return(eleven.getText());
        else if(second == 11)
            return(twelve.getText());
        else if(second == 12)
            return(thirteen.getText());
        else if(second == 13)
            return(fourteen.getText());
        else if(second == 14)
            return(fifteen.getText());
        else
            return("");
    
    }
    
    public String findThird(){

    
        if(third == 0)
            return(one.getText());
        else if(third == 1)
            return(two.getText());
        else if(third == 2)
            return(three.getText());
        else if(third == 3)
            return(four.getText());
        else if(third == 4)
            return(five.getText());
        else if(third == 5)
            return(six.getText());
        else if(third == 6)
            return(seven.getText());
        else if(third == 7)
            return(eight.getText());
        else if(third == 8)
            return(nine.getText());
        else if(third == 9)
            return(ten.getText());
        else if(third == 10)
            return(eleven.getText());
        else if(third == 11)
            return(twelve.getText());
        else if(third == 12)
            return(thirteen.getText());
        else if(third == 13)
            return(fourteen.getText());
        else if(third == 14)
            return(fifteen.getText());
        else
            return("");
    
    }
    
    public void runGame(){
        if(totalQCount == 20){
            t.stop();
            flashWinner();
            question.setText("Game Over! \n Winners: \n 1st Place: " + findFirst()
            + "\n 2nd Place: " + findSecond() + "\n 3rd Place: " + findThird());
            timer1.setText("");
            timer2.setText("");
            //startTimer();
            nextQuestion.setVisible(false);
            revealAnswer.setVisible(false);
            tCounts = 0;
        }else{
        

                if(totalQCount == 5 || totalQCount == 10 || totalQCount == 15){
                   catCount++;
                   roundCount++; 
                }
                roundNum.setText(Integer.toString(roundCount)); 
                rsNum.setText(Integer.toString(roundCount)); 
            
                CatName.setText(categories[chooseC[catCount]]);
                qNum.setText(Integer.toString(totalQCount+1));
                qn.setText(Integer.toString(totalQCount+1));
                
                question.setText(questions[chooseQ[totalQCount]][1]);
                totalQCount++;
        
        
        
    }

        
    }
    
    public void startTimer() {
        timerCount = 0;
        tCounts++;
        timer1.setText("120");
        timer2.setText("120");
        t = new Timer(1000, new ActionListener(){
                            
            @Override
            public void actionPerformed(ActionEvent ae){
                if(tCounts < 21){
                    timer1.setText(Integer.toString(119 - timerCount));
                    timer2.setText(Integer.toString(119 - timerCount));
                }else{
                    timer1.setText("");
                    timer2.setText("");
                }
                timerCount++;
                if(timerCount == 120){
                    timerCount = 0;
                    t.stop();
                    question.setText("Time's up!");
                }
                
            }
        });
        t.start();
        
    
    }
 
    public void flashWinner() {
        wCount = 0;
        for(int x = 0; x < 15; x++){
            if(totalScore[x] > totalScore[first] || totalScore[x] == totalScore[first]){
                third = second;
                second = first;
                first = x;
            }else if(totalScore[x] > totalScore[second] || totalScore[x] == totalScore[second]){
                third = second;
                second = x;
            }else if(totalScore[x] > totalScore[third]){
                    third = x;
            }
                
        }
        
        t2 = new Timer(1000, new ActionListener(){
                            
            @Override
            public void actionPerformed(ActionEvent ae){
                    wCount++;
                    if((wCount%2) == 0){
                        tScore[first].setText("");
                        tScore[second].setText("");
                        tScore[third].setText("");
                    }else{
                        tScore[first].setText(String.valueOf(totalScore[first]));
                        tScore[second].setText(String.valueOf(totalScore[second]));
                        tScore[third].setText(String.valueOf(totalScore[third]));
                    }
                    
                

                
            }
        });
        t2.start();
        
    
    }
    
   
    
    public void updateScores(){
    
        for(int x = 0; x < 15; x++){
            if(roundScore[x]==0)
                rScore[x].setText("");
            else
                rScore[x].setText(String.valueOf(roundScore[x]));
            if(totalScore[x]==0)
                tScore[x].setText("");
            else
                tScore[x].setText(String.valueOf(totalScore[x]));
        }
    
    }
    
    
    
    public void displayScores(){
    
        if(tn1.getText().equals("")){
            one.setVisible(false);
            checkbox1.setVisible(false);
            r1.setVisible(false);
            tot1.setVisible(false);
        }else{
            one.setVisible(true);
            checkbox1.setVisible(true);
            r1.setVisible(true);
            tot1.setVisible(true);
        }
        if(tn2.getText().equals("")){
            two.setVisible(false);
            checkbox2.setVisible(false);
            r2.setVisible(false);
            tot2.setVisible(false);
        }else{
            two.setVisible(true);
            checkbox2.setVisible(true);
            r2.setVisible(true);
            tot2.setVisible(true);
        }
        if(tn3.getText().equals("")){
            three.setVisible(false);
            checkbox3.setVisible(false);
            r3.setVisible(false);
            tot3.setVisible(false);
        }else{
            three.setVisible(true);
            checkbox3.setVisible(true);
            r3.setVisible(true);
            tot3.setVisible(true);
        }
        if(tn4.getText().equals("")){
            four.setVisible(false);
            checkbox4.setVisible(false);
            r4.setVisible(false);
            tot4.setVisible(false);
        }else{
            four.setVisible(true);
            checkbox4.setVisible(true);
            r4.setVisible(true);
            tot4.setVisible(true);
        }
        if(tn5.getText().equals("")){
            five.setVisible(false);
            checkbox5.setVisible(false);
            r5.setVisible(false);
            tot5.setVisible(false);
        }else{
            five.setVisible(true);
            checkbox5.setVisible(true);
            r5.setVisible(true);
            tot5.setVisible(true);
        }
        if(tn6.getText().equals("")){
            six.setVisible(false);
            checkbox6.setVisible(false);
            r6.setVisible(false);
            tot6.setVisible(false);
        }else{
            six.setVisible(true);
            checkbox6.setVisible(true);
            r6.setVisible(true);
            tot6.setVisible(true);
        }
        if(tn7.getText().equals("")){
            seven.setVisible(false);
            checkbox7.setVisible(false);
            r7.setVisible(false);
            tot7.setVisible(false);
        }else{
            seven.setVisible(true);
            checkbox7.setVisible(true);
            r7.setVisible(true);
            tot7.setVisible(true);
        }
        if(tn8.getText().equals("")){
            eight.setVisible(false);
            checkbox8.setVisible(false);
            r8.setVisible(false);
            tot8.setVisible(false);
        }else{
            eight.setVisible(true);
            checkbox8.setVisible(true);
            r8.setVisible(true);
            tot8.setVisible(true);
        }
        if(tn9.getText().equals("")){
            nine.setVisible(false);
            checkbox9.setVisible(false);
            r9.setVisible(false);
            tot9.setVisible(false);
        }else{
            nine.setVisible(true);
            checkbox9.setVisible(true);
            r9.setVisible(true);
            tot9.setVisible(true);
        }
        if(tn10.getText().equals("")){
            ten.setVisible(false);
            checkbox10.setVisible(false);
            r10.setVisible(false);
            tot10.setVisible(false);
        }else{
            ten.setVisible(true);
            checkbox10.setVisible(true);
            r10.setVisible(true);
            tot10.setVisible(true);
        }
        if(tn11.getText().equals("")){
            eleven.setVisible(false);
            checkbox11.setVisible(false);
            r11.setVisible(false);
            tot11.setVisible(false);
        }else{
            eleven.setVisible(true);
            checkbox11.setVisible(true);
            r11.setVisible(true);
            tot11.setVisible(true);
        }
        if(tn12.getText().equals("")){
            twelve.setVisible(false);
            checkbox12.setVisible(false);
            r12.setVisible(false);
            tot12.setVisible(false);
        }else{
            twelve.setVisible(true);
            checkbox12.setVisible(true);
            r12.setVisible(true);
            tot12.setVisible(true);
        }
        if(tn13.getText().equals("")){
            thirteen.setVisible(false);
            checkbox13.setVisible(false);
            r13.setVisible(false);
            tot13.setVisible(false);
        }else{
            thirteen.setVisible(true);
            checkbox13.setVisible(true);
            r13.setVisible(true);
            tot13.setVisible(true);
        }
        if(tn14.getText().equals("")){
            fourteen.setVisible(false);
            checkbox14.setVisible(false);
            r14.setVisible(false);
            tot14.setVisible(false);
        }else{
            fourteen.setVisible(true);
            checkbox14.setVisible(true);
            r14.setVisible(true);
            tot14.setVisible(true);
        }
        if(tn15.getText().equals("")){
            fifteen.setVisible(false);
            checkbox15.setVisible(false);
            r15.setVisible(false);
            tot15.setVisible(false);
        }else{
            fifteen.setVisible(true);
            checkbox15.setVisible(true);
            r15.setVisible(true);
            tot15.setVisible(true);
        }
    
    }
    
    private void instantiateArrays(){
    
        for(int i = 0; i < 10000; i++){
            questions[i][0]= "";
            questions[i][1]= "";
            questions[i][2]= "";
        }
        
        for(int i = 0; i < 1000; i++){
            categories[i] = "";
        }
        
        for(int i = 0; i < 20; i++){
            usedQs[i] = 999999;
        }
        
        for(int i = 0; i < 5; i++){
            usedCs[i]= 99999;
        }
        
    
    }
    
    
    private void loadJLabels(){
    
        rScore[0] = r1;
        tScore[0] = tot1;
        rScore[1] = r2;
        tScore[1] = tot2;
        rScore[2] = r3;
        tScore[2] = tot3;
        rScore[3] = r4;
        tScore[3] = tot4;
        rScore[4] = r5;
        tScore[4] = tot5;
        rScore[5] = r6;
        tScore[5] = tot6;
        rScore[6] = r7;
        tScore[6] = tot7;
        rScore[7] = r8;
        tScore[7] = tot8;
        rScore[8] = r9;
        tScore[8] = tot9;
        rScore[9] = r10;
        tScore[9] = tot10;
        rScore[10] = r11;
        tScore[10] = tot11;
        rScore[11] = r12;
        tScore[11] = tot12;
        rScore[12] = r13;
        tScore[12] = tot13;
        rScore[13] = r14;
        tScore[13] = tot14;
        rScore[14] = r15;
        tScore[14] = tot15;
        
    
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
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trivia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CatName;
    private javax.swing.JPanel Game;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel Score;
    private javax.swing.JTabbedPane Scores;
    private javax.swing.JTextField Team1;
    private javax.swing.JTextField Team10;
    private javax.swing.JTextField Team11;
    private javax.swing.JTextField Team12;
    private javax.swing.JTextField Team13;
    private javax.swing.JTextField Team14;
    private javax.swing.JTextField Team15;
    private javax.swing.JTextField Team2;
    private javax.swing.JTextField Team3;
    private javax.swing.JTextField Team4;
    private javax.swing.JTextField Team5;
    private javax.swing.JTextField Team6;
    private javax.swing.JTextField Team7;
    private javax.swing.JTextField Team8;
    private javax.swing.JTextField Team9;
    private javax.swing.JPanel Teams;
    private java.awt.Checkbox checkbox1;
    private java.awt.Checkbox checkbox10;
    private java.awt.Checkbox checkbox11;
    private java.awt.Checkbox checkbox12;
    private java.awt.Checkbox checkbox13;
    private java.awt.Checkbox checkbox14;
    private java.awt.Checkbox checkbox15;
    private java.awt.Checkbox checkbox2;
    private java.awt.Checkbox checkbox3;
    private java.awt.Checkbox checkbox4;
    private java.awt.Checkbox checkbox5;
    private java.awt.Checkbox checkbox6;
    private java.awt.Checkbox checkbox7;
    private java.awt.Checkbox checkbox8;
    private java.awt.Checkbox checkbox9;
    private javax.swing.JButton clearTeams;
    private javax.swing.JLabel eight;
    private javax.swing.JLabel eleven;
    private javax.swing.JLabel fifteen;
    private javax.swing.JLabel five;
    private javax.swing.JLabel four;
    private javax.swing.JLabel fourteen;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newGame;
    private javax.swing.JButton nextQuestion;
    private javax.swing.JLabel nine;
    private javax.swing.JLabel one;
    private javax.swing.JLabel qNum;
    private javax.swing.JLabel qn;
    private javax.swing.JTextArea question;
    private javax.swing.JLabel r1;
    private javax.swing.JLabel r10;
    private javax.swing.JLabel r11;
    private javax.swing.JLabel r12;
    private javax.swing.JLabel r13;
    private javax.swing.JLabel r14;
    private javax.swing.JLabel r15;
    private javax.swing.JLabel r2;
    private javax.swing.JLabel r3;
    private javax.swing.JLabel r4;
    private javax.swing.JLabel r5;
    private javax.swing.JLabel r6;
    private javax.swing.JLabel r7;
    private javax.swing.JLabel r8;
    private javax.swing.JLabel r9;
    private javax.swing.JButton revealAnswer;
    private javax.swing.JLabel roundNum;
    private javax.swing.JLabel rsNum;
    private javax.swing.JLabel seven;
    private javax.swing.JLabel six;
    private javax.swing.JButton submitQuestionScore;
    private javax.swing.JButton submitTeams;
    private javax.swing.JLabel ten;
    private javax.swing.JLabel thirteen;
    private javax.swing.JLabel three;
    private javax.swing.JLabel timer1;
    private javax.swing.JLabel timer2;
    private javax.swing.JLabel tn1;
    private javax.swing.JLabel tn10;
    private javax.swing.JLabel tn11;
    private javax.swing.JLabel tn12;
    private javax.swing.JLabel tn13;
    private javax.swing.JLabel tn14;
    private javax.swing.JLabel tn15;
    private javax.swing.JLabel tn2;
    private javax.swing.JLabel tn3;
    private javax.swing.JLabel tn4;
    private javax.swing.JLabel tn5;
    private javax.swing.JLabel tn6;
    private javax.swing.JLabel tn7;
    private javax.swing.JLabel tn8;
    private javax.swing.JLabel tn9;
    private javax.swing.JLabel tot1;
    private javax.swing.JLabel tot10;
    private javax.swing.JLabel tot11;
    private javax.swing.JLabel tot12;
    private javax.swing.JLabel tot13;
    private javax.swing.JLabel tot14;
    private javax.swing.JLabel tot15;
    private javax.swing.JLabel tot2;
    private javax.swing.JLabel tot3;
    private javax.swing.JLabel tot4;
    private javax.swing.JLabel tot5;
    private javax.swing.JLabel tot6;
    private javax.swing.JLabel tot7;
    private javax.swing.JLabel tot8;
    private javax.swing.JLabel tot9;
    private javax.swing.JLabel twelve;
    private javax.swing.JLabel two;
    // End of variables declaration//GEN-END:variables
}
