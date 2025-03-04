package com.stu.mhl.view;

import com.stu.mhl.domain.Employee;
import com.stu.mhl.service.EmployeeService;
import com.stu.mhl.utils.Utility;

/**
 * @author Mark He
 * @version 1.0
 * 主界面
 */
public class MHLView {
    private boolean loop = true;
    private String key = "";//表示接受用户的输入
    //定义EmployeeService属性
    private EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        MHLView view = new MHLView();
        view.mainMenu();

    }

    //显示主菜单
    public void mainMenu() {
        while (loop) {
            System.out.println("=============满汉楼==============");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入员工号：");
                    String empId = Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String pwd = Utility.readString(50);
                    //到数据库去判断
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    if (employee != null) {
                        System.out.println("=====================登录成功[" + employee.getName() + "]===================");
                        //显示二级菜单,二级菜单是循环操作，因此做成while
                        while (loop) {
                            System.out.println("======================满汉楼（二级菜单）======================");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    System.out.println("显示餐桌状态");
                                    break;
                                case "2":
                                    System.out.println(222222);
                                    break;
                                case "3":
                                    System.out.println(33333);
                                    break;
                                case "4":
                                    System.out.println(444444);
                                    break;
                                case "5":
                                    System.out.println(5555555);
                                    break;
                                case "6":
                                    System.out.println(666666);
                                    break;
                                case "9":
                                    loop = false;
                                    System.out.println(999999);
                                    break;
                                default:
                                    System.out.println("你的输入有误，请重新输入");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("=====================登录失败===================");
                    }

                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("你的输入有误，请重新输入。");
                    break;
            }
        }
        System.out.println("===============退出满汉楼===============");
    }
}