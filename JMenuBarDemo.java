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
		MyFrame frame = new MyFrame("我的windows窗口");
		int screen_width = (int)frame.getToolkit().getScreenSize().getWidth();
		int screen_height = (int)frame.getToolkit().getScreenSize().getHeight();
		frame.setSize(width, height);
		//如何给窗口设置默认的图标
		URL url = frame.getClass().getResource("pic/manual.gif");
		Image img = frame.getToolkit().getImage(url);
		frame.setIconImage(img);
		//创建菜单栏
		JMenuBar bar = new JMenuBar();
		//创建文件菜单
		JMenu fileMenu = new JMenu("文件");
		fileMenu.setIcon(new ImageIcon("pic/file.gif"));
		JMenuItem newItem = new JMenuItem("新建",new ImageIcon("pic/newItem.gif"));
		
		
		JMenuItem openItem = new JMenuItem("打开");
		JMenuItem saveItem = new JMenuItem("保存");
		JMenuItem quitItem = new JMenuItem("关闭");
		
		
		//N
		//newItem.setMnemonic(java.awt.event.KeyEvent.VK_N);
		//CTRL+N
		newItem.setAccelerator(KeyStroke.getKeyStroke('N',java.awt.event.KeyEvent.CTRL_MASK));
		newItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showConfirmDialog(null, "您点击了新建菜单项", "提示信息", JOptionPane.INFORMATION_MESSAGE, JOptionPane.OK_OPTION);
			}
			
		});
		quitItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = (int)JOptionPane.showConfirmDialog(null, "您真的要退出吗？", "提示信息", JOptionPane.OK_CANCEL_OPTION);
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
		
		//设置窗口在屏幕中间显示
		frame.setLocation((screen_width-width)/2, (screen_height-height)/2);
//		frame.setLocation(0, 0);
		frame.setVisible(true);
		frame.setResizable(false);//设置窗口不可编辑
		bar.add(fileMenu);	
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.addSeparator();;
		fileMenu.add(saveItem);
		fileMenu.add(quitItem);
		frame.setJMenuBar(bar);

	}

}
