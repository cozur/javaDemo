import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class JMenuBarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int width = 600;
		int height = 400;
		MyFrame frame = new MyFrame("�ҵ�windows����");
		int screen_width = (int)frame.getToolkit().getScreenSize().getWidth();
		int screen_height = (int)frame.getToolkit().getScreenSize().getHeight();
		frame.setSize(width, height);
		//��θ���������Ĭ�ϵ�ͼ��
		URL url = frame.getClass().getResource("pic/manual.gif");
		Image img = frame.getToolkit().getImage(url);
		frame.setIconImage(img);
		//�����˵���
		JMenuBar bar = new JMenuBar();
		//�����ļ��˵�
		JMenu fileMenu = new JMenu("�ļ�");
		fileMenu.setIcon(new ImageIcon("pic/file.gif"));
		JMenuItem newItem = new JMenuItem("�½�",new ImageIcon("pic/newItem.gif"));
		
		
		JMenuItem openItem = new JMenuItem("��");
		JMenuItem saveItem = new JMenuItem("����");
		JMenuItem quitItem = new JMenuItem("�ر�");
		
		
		//N
		//newItem.setMnemonic(java.awt.event.KeyEvent.VK_N);
		//CTRL+N
		newItem.setAccelerator(KeyStroke.getKeyStroke('N',java.awt.event.KeyEvent.CTRL_MASK));
		newItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showConfirmDialog(null, "��������½��˵���", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_OPTION);
			}
			
		});
		quitItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = (int)JOptionPane.showConfirmDialog(null, "�����Ҫ�˳���", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION)
				{
					System.exit(0);
				}
				else
				{
					return;
				}
			}
			
		});
		
		//���ô�������Ļ�м���ʾ
		frame.setLocation((screen_width-width)/2, (screen_height-height)/2);
//		frame.setLocation(0, 0);
		frame.setVisible(true);
		frame.setResizable(false);//���ô��ڲ��ɱ༭
		bar.add(fileMenu);	
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.addSeparator();;
		fileMenu.add(saveItem);
		fileMenu.add(quitItem);
		frame.setJMenuBar(bar);

	}

}
