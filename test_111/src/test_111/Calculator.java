package test_111;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
public class Calculator extends JFrame {
	private static final long serialVersionUID = 2951562130829610400L;
	private JTextField textField;
    private ActionListener myListener;
	public Calculator() {
		setTitle("计算器"); // 设置名字为计算器
		setSize(300, 300); // 设置大下为 300x300
		setLocationRelativeTo(null); // 设置位置为居中
		setResizable(false); // 设置为大小不可变的
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 可以退出
		Container container = getContentPane(); // 新建一个容器
        container.setLayout(new BorderLayout(50, 50)); // 设置上下间距为50px
		JPanel pnlNorth = new JPanel();  
		JPanel pnlCenter = new JPanel(); 
        // 把textFeild和panel 都放到容器上
		container.add(pnlNorth, BorderLayout.NORTH); // 把pnlNorth放在北面
        container.add(pnlCenter, BorderLayout.CENTER); // 把pnlCenter放在center面
        textField = new JTextField();  // 文本框设置
        textField.setFont(new Font("宋体", Font.PLAIN, 16));
        textField.setEditable(false);  // 不可修改
        textField.setHorizontalAlignment (JTextField.RIGHT); //设置输出右对齐
        pnlNorth.setLayout(new BorderLayout(5, 5)); // 设置上边的文本框和按钮的位置为边界布局

        JButton btnClear = useButton("Record"); // new一个button按钮
        JButton btn = useButton("Standard");
        pnlNorth.add(btn,BorderLayout.WEST);
        pnlNorth.add(textField, BorderLayout.SOUTH); // 将文本框放到中间
		pnlNorth.add(btnClear, BorderLayout.EAST); // 将按钮放到做左边（西）
        String[] titles = {
        		"CE","C","←","/",
				"7", "8", "9", "*", 
				"4", "5", "6", "-",
				"1", "2", "3", "+",
				"#", "0", ".", "="
		};
		// 设置panel为网格布局，5行4列，间距就都设为6
		pnlCenter.setLayout(new GridLayout(5, 4, 6, 6));
		for (int i = 0; i < titles.length; i++) {
			JButton btnNum = useButton(titles[i]);
			btnNum.setFont(new Font("黑体",Font.PLAIN, 16));
			pnlCenter.add(btnNum);
		}
    }
	public JButton useButton (final String titles) {
		JButton button = new JButton(String.valueOf(titles));
        button.addActionListener(myListener);		
        return button;
    }
    public static void main(String[] args) {
		new Calculator().setVisible(true);
    }
}
