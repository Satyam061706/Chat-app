import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.*;
import java.net.*;
public class Server  extends JFrame {
    static BufferedReader br;
    ServerSocket server;
     static Socket socket;
//    BufferedReader br;
static PrintWriter out;

    //   Declare Component
    private JLabel heading=new JLabel("Server Area");
    private JTextArea messagearea=new JTextArea();
    private JTextField messageinput=new JTextField();
    private Font font=new Font("Roboto",Font.PLAIN,20);

    //constructor
    public Server()
    {
        try {
            server=new ServerSocket(7777);
            System.out.println("server is ready to accept connection");
            System.out.println("Wating....");
            socket=server.accept();

            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());

            createGUI();
            handleEvents();
            startReading();
//            startWriting();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleEvents() {
        messageinput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
//               System.out.println("key released"+e.getKeyCode());
                if(e.getKeyCode()==10){
                    System.out.println("you have pressed enter button");
                    String contentToSend=messageinput.getText();
                    messagearea.append("Me : "+contentToSend+"\n");
                    out.println(contentToSend);
                    out.flush();
                    messageinput.setText("");
                    messageinput.requestFocus();
                }
            }
        });
    }

    private void createGUI() {
        this.setTitle("Server Messager");
        this.setSize(600,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//       coding for component
        heading.setFont(font);
        messagearea.setFont(font);
        messageinput.setFont(font);
        heading.setIcon(new ImageIcon("logo4.png"));

        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);

        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        messagearea.setEditable(false);
        messageinput.setHorizontalAlignment(SwingConstants.CENTER);

//        frame ka layout
        this.setLayout(new BorderLayout());

//        adding the component to frame

        this.add(heading,BorderLayout.NORTH);
        JScrollPane jScrollPane=new JScrollPane(messagearea);
        this.add(jScrollPane,BorderLayout.CENTER);
        this.add(messageinput,BorderLayout.SOUTH);



        this.setVisible(true);
    }

    public  void startReading()
    {
    //   thread-reading
        Runnable r1=()->{
            System.out.println("reader started..");
            try {
            while(true){
                String msg = br.readLine();
                if (msg.equals("exit")) {
                    System.out.println("Client terminated the chat");
                    JOptionPane.showMessageDialog(this,"Server terminate the chat");
                    messageinput.setEnabled(false);
                    socket.close();
                    break;
                }
//                System.out.println("Client : " + msg);
                messagearea.append("Client : "+msg+"\n");
            }
            }catch (Exception e){
               // e.printStackTrace();
                System.out.println("Connection is closed ");
            }
        };
        new Thread(r1).start();
    }
    public static void startWriting()
    {
//        thread-taking data from user  and send it to client
        Runnable r2=()->{
            System.out.println("writter started..");
                try {
            while (!socket.isClosed()){
                    BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                    String content =br1.readLine();
                    out.println(content);
                    out.flush();
                    if(content.equals("exit")){
                        socket.close();
                        break;
                    }
            }
                    System.out.println("Connection is closed ");
                }catch (Exception e){
                    e.printStackTrace();
                }

    };
        new Thread(r2).start();
    }
    public static void main(String[] args) {

        System.out.println("This is a Server..");
        new Server();
    }
}
