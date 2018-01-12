# IM_Tencent
一款基于java的仿QQ的即时通信应用  
a simple java application copy QQ  

应用截图如下  
the snapshot of the application  

## Server(服务器端)
先运行Tecent_Server  
firstly run the Tecent_Server  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/1.jpg)

然后点击增加成员按钮    
then click the button like  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/4.jpg)

接着点击开启按钮  
then click the button like  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/5.jpg)

可以看到如下界面  
you will see the following image  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/2.jpg)

记住IP地址  
remember the ip address  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/3.jpg)

## Client(用户端)
运行Tecent_Beta  
run the Tecent_Beta  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/6.jpg)

确认IP地址与服务器一致，后点击确认后你会看到登陆界面  
after making sure that the ip address is the same as the server, click the confirm button, you will see the login interface  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/7.jpg)

点击头像位置可以选择头像  
click the position of avatar you can select other avatars  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/8.jpg)

后按照服务器端的用户列表填写用户名和对应的密码  
then type in the username and password according to the user list of the server interface  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/9.jpg)

点登陆后会进入主界面  
after clicking the confirm button you will see the main interface  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/10.jpg)

然后多运行Tecent_Beta两次再登陆两个账号  
then run Tecent_Beta twice to login in two other accounts  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/11.jpg)
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/12.jpg)

接下来可以一对一聊天了  
then you can chat with others who have logined on one by one  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/13.jpg)

或者群聊  
or use the group chat function  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/14.jpg)

还可以传文件（直接将文件拖到聊天窗口即可），文件默认存储于F盘  
what's more you can transfer the file using this application(just drag the target file into the chat window), and the default receiver address is on F drive  
![image](https://github.com/chenhuaizhen/IM_Tencent/raw/master/image/15.jpg)

由于本应用只是练手，所以网络连接方式采用了RMI和Socket两种方式，详情见代码  
because this application is a train demo, the internet connection is based on the RMI and socket, the more details are shown in the codes  

打包成的jar可以直接运行，也是要先运行Tecent_Server.jar后再运行Tecent_Beta.jar  
the .jar application in jar folder can run straightly, but note that you should run the Tecent_Server.jar firstly then run the Tecent_Beta.jar