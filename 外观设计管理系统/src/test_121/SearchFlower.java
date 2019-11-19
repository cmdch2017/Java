package test_121;


import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.util.ArrayList;

public class SearchFlower extends JFrame implements ActionListener

{

    JLabel tableLabel;//标题

    JScrollPane tablePane;//滚动视口

    JTable table;//花卉列表

    

    JLabel NumLabel;//编号标题

    JLabel NameLabel;//名称标题

    JLabel PriceLabel;//单价标题

    JLabel UnitLabel;//计价单位标题

    JPanel panel;

    JComboBox comboBox;//组合框

    JTextField SearchText;//搜索文本框

    JButton SearchButton;//搜索按键

    JButton[] rbts;//按钮数组对象

    ButtonGroup btGroup;//按钮组，从逻辑上来涵盖所有的单选按钮

    

    public SearchFlower()

    {

        this.setLayout(null);

        this.setSize(700, 580);

        this.setTitle("外观设计专利信息管理系统");

        this.setLocation(600,250);

        this.setBackground(Color.lightGray);

        this.init();

        this.refreshTable();

        this.setVisible(true);

    }

    private void init()

    {

        //增删查改功能入口按钮

        btGroup=new ButtonGroup();

        rbts=new JButton[4];

        String[] strs = {"增加","删除","搜索","修改"};

        for(int i = 0;i<strs.length;i++)

        {

            rbts[i]=new JButton(strs[i]);

            rbts[i].setSize(70, 30);

            rbts[i].setLocation(150*i+80, 10);

            btGroup.add(rbts[i]);//从逻辑上将单选按钮添加到一个按钮数组中

            this.add(rbts[i]);//从物理位置上将单选按钮添加到窗体中

            rbts[i].addActionListener(this);

        }

        

        

        String[] string = { "搜索条件", "编号", "名称" };

        comboBox = new JComboBox(string);

        comboBox.setSize(100,30);

        comboBox.setLocation(50,70);

        this.add(comboBox);

        

        SearchText = new JTextField();

        SearchText.setSize(180,30);

        SearchText.setLocation(170, 70);

        this.add(SearchText);

        

        SearchButton = new JButton("搜索");

        SearchButton.setSize(70, 30);

        SearchButton.setLocation(380, 70);

        SearchButton.addActionListener(new ActionListener()

        {

            @Override

            public void actionPerformed(ActionEvent e) {

                String item = (String)comboBox.getSelectedItem();

                ArrayList<String> result=new ArrayList<String>();

                if("搜索条件".equals(item))

                {

                    SearchText.setText("");

                }else if("编号".equals(item)){

                    //根据编号进行查找的方法

                    if(checkIsNull()){

                        result.add(FlowerDAO.findFlowerBySno(SearchText.getText().trim()));

                        JOptionPane.showMessageDialog(null, result.clone());

                    }else{

                        JOptionPane.showMessageDialog(null, "未输入查询信息","提示", JOptionPane.ERROR_MESSAGE);

                    }

                    

                }else if("名称".equals(item)){

                    //根据名称进行查找的方法

                    if(checkIsNull())

                    {

                        result.add(FlowerDAO.findFlowerBySname(SearchText.getText().trim()));

                        JOptionPane.showMessageDialog(null, result.clone());

                    }else{

                        JOptionPane.showMessageDialog(null, "未输入查询信息", "提示", JOptionPane.ERROR_MESSAGE);

                    }

                }

            }

        }

                    

        );

        this.add(SearchButton);    

    }

    

    private void refreshTable()

    {

        tableLabel = new JLabel("外观设计经费");    

        tableLabel.setBounds(300,105, 100, 50);

        tableLabel.setFont(new Font("宋体", Font.BOLD , 20));

        

        String[] columnNames = {"编号","名称","单价","备注"};

        FlowerDAO dao=new FlowerDAO();

        ArrayList<String> flos=dao.findAllFlowers();

        Object[][] objs=new Object[flos.size()][4];

        for(int i=0;i<flos.size();i++)

        {

            String[] strs1=flos.get(i).split(",");

            objs[i][0]=strs1[0];

            objs[i][1]=strs1[1];

            objs[i][2]=strs1[2];

            objs[i][3]=strs1[3];

        }
        System.out.println("正在查找界面");
        

        table=new JTable(objs,columnNames);

        table.setSize(380,150);

        tablePane = new JScrollPane(table);

        tablePane.setSize(660, 350);

        tablePane.setLocation(10, 150);

        table.getTableHeader().setReorderingAllowed(false);

        table.getTableHeader().setResizingAllowed(false);

        table.enable(false);

        //this.removeAll();

        //this.init();

        this.add(tableLabel);

        this.add(tablePane);

    }

    

    @Override

    public void actionPerformed(ActionEvent e) {

         String buttonName = e.getActionCommand();

          if(buttonName.equals("增加")){

              AddFlower addflower = new AddFlower();

          }else if(buttonName.equals("删除")){

              DeleteFlower deleteflower = new DeleteFlower();

          }else if(buttonName.equals("搜索")){

              System.out.println("已处在搜索界面上");

          }else{

              ModifyFlower modifyflower = new ModifyFlower();

          }

        

    }

    

    private boolean checkIsNull()

    {

        boolean flag=true;

        if(SearchText.getText().trim().equals(""))

        {

            flag = false;

        }

        return flag;

    }

    

    private Object checkInput()

    {    

        String result="";

        String result1="";

            for(int i=0;i<SearchText.getText().trim().length();i++)

            {

                char ch=SearchText.getText().trim().charAt(i);

                if((ch<'0')||(ch>'9'))

                {

                    result="编号中包含非数字字符";

                    break;

                }else

                {

                    result="";

                    break;

                }

            }

            return result;

        

    }

 

 

}
