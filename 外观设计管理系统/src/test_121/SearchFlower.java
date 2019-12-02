package test_121;


import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.util.ArrayList;

public class SearchFlower extends JFrame implements ActionListener

{

    JLabel tableLabel;//����

    JScrollPane tablePane;//�����ӿ�

    JTable table;//�����б�

    

    JLabel NumLabel;//��ű���

    JLabel NameLabel;//���Ʊ���

    JLabel PriceLabel;//���۱���

    JLabel UnitLabel;//�Ƽ۵�λ����

    JPanel panel;

    JComboBox comboBox;//��Ͽ�

    JTextField SearchText;//�����ı���

    JButton SearchButton;//��������

    JButton[] rbts;//��ť�������

    ButtonGroup btGroup;//��ť�飬���߼������������еĵ�ѡ��ť

    

    public SearchFlower()

    {

        this.setLayout(null);

        this.setSize(700, 580);

        this.setTitle("������ר����Ϣ����ϵͳ");

        this.setLocation(600,250);

        this.setBackground(Color.lightGray);

        this.init();

        this.refreshTable();

        this.setVisible(true);

    }

    private void init()

    {

        //��ɾ��Ĺ�����ڰ�ť

        btGroup=new ButtonGroup();

        rbts=new JButton[4];

        String[] strs = {"����","ɾ��","����","�޸�"};

        for(int i = 0;i<strs.length;i++)

        {

            rbts[i]=new JButton(strs[i]);

            rbts[i].setSize(70, 30);

            rbts[i].setLocation(150*i+80, 10);

            btGroup.add(rbts[i]);//���߼��Ͻ���ѡ��ť��ӵ�һ����ť������

            this.add(rbts[i]);//������λ���Ͻ���ѡ��ť��ӵ�������

            rbts[i].addActionListener(this);

        }

        

        

        String[] string = { "��������", "���", "����" };

        comboBox = new JComboBox(string);

        comboBox.setSize(100,30);

        comboBox.setLocation(50,70);

        this.add(comboBox);

        

        SearchText = new JTextField();

        SearchText.setSize(180,30);

        SearchText.setLocation(170, 70);

        this.add(SearchText);

        

        SearchButton = new JButton("����");

        SearchButton.setSize(70, 30);

        SearchButton.setLocation(380, 70);

        SearchButton.addActionListener(new ActionListener()

        {

            @Override

            public void actionPerformed(ActionEvent e) {

                String item = (String)comboBox.getSelectedItem();

                ArrayList<String> result=new ArrayList<String>();

                if("��������".equals(item))

                {

                    SearchText.setText("");

                }else if("���".equals(item)){

                    //���ݱ�Ž��в��ҵķ���

                    if(checkIsNull()){

                        result.add(FlowerDAO.findFlowerBySno(SearchText.getText().trim()));

                        JOptionPane.showMessageDialog(null, result.clone());

                    }else{

                        JOptionPane.showMessageDialog(null, "δ�����ѯ��Ϣ","��ʾ", JOptionPane.ERROR_MESSAGE);

                    }

                    

                }else if("����".equals(item)){

                    //�������ƽ��в��ҵķ���

                    if(checkIsNull())

                    {

                        result.add(FlowerDAO.findFlowerBySname(SearchText.getText().trim()));

                        JOptionPane.showMessageDialog(null, result.clone());

                    }else{

                        JOptionPane.showMessageDialog(null, "δ�����ѯ��Ϣ", "��ʾ", JOptionPane.ERROR_MESSAGE);

                    }

                }

            }

        }

                    

        );

        this.add(SearchButton);    

    }

    

    private void refreshTable()

    {

        tableLabel = new JLabel("�����ƾ���");    

        tableLabel.setBounds(300,105, 100, 50);

        tableLabel.setFont(new Font("����", Font.BOLD , 20));

        

        String[] columnNames = {"���","����","����","��ע"};

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
        System.out.println("���ڲ��ҽ���");
        

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

          if(buttonName.equals("����")){

              AddFlower addflower = new AddFlower();

          }else if(buttonName.equals("ɾ��")){

              DeleteFlower deleteflower = new DeleteFlower();

          }else if(buttonName.equals("����")){

              System.out.println("�Ѵ�������������");

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

                    result="����а����������ַ�";

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
