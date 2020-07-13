import java.util.*
import kotlin.system.exitProcess

//密码
var password = 123456
//总金额
var tolmoney = 2000
//Scanner
val scanner = Scanner(System.`in`)
//密码记错
var wrongtime = 0


fun main() {
    //欢迎界面
    welcom()
    //输入密码
    inPWD()
    //选择操作
    while (true){
        var op = showOptions()
        when(op){
            //查询
            1->consult()
            //存款
            2->deposit()
            //取款
            3->withDraw()
            //更改密码
            4->changePassword()
            //退出
            5->myExit()
        }
        //是否继续
        ifContinue()
    }

}

//欢迎界面
fun welcom(){
    println("**********************\n")
    println("      欢迎使用！\n")
    println("**********************")
}

//验证密码
fun inPWD(){
    wrongtime = 0
    while (true){
        print("请输入密码：")
        var inputPassword = scanner.nextInt()
        if (password == inputPassword){
            println("密码正确！")
            break
        }else{
            println("密码错误！")
            wrongtime++
            if (wrongtime > 3){
                println("密码错误次数过多，账号已冻结！")
                exitProcess(1)
            }
        }
    }
}

//查询
fun consult(){
    println("当前余额为：$tolmoney")
}

//存款
fun deposit(){
    print("输入存款金额：")
    var inMoney = scanner.nextInt()
    tolmoney += inMoney
    print("存款成功，")
}

//取款
fun withDraw(){
    print("输入取款金额：")
    var outMoney = scanner.nextInt()
    if (tolmoney >= outMoney)
        tolmoney -= outMoney
    else
        println("金额不足，无法取款！")
}

//更改密码
fun changePassword(){
    wrongtime = 0
    while (true){
        print("请输入原密码：")
        var orgPWD = scanner.nextInt()
        //判断密码
        if (orgPWD == password) {
            print("请输入新密码：")
            var firstSet = scanner.nextInt()
            print("请再次确认密码：")
            var secondSet = scanner.nextInt()
            if (firstSet == secondSet) {
                password = firstSet
                println("更改密码成功!")
                break
            }else{
                print("密码更改失败！")
                wrongtime = 0
            }
        }else{
            //密码错误
            wrongtime++
            if (wrongtime > 3){
                println("密码错误次数过多，账号已冻结！")
                exitProcess(1)
            }
        }
    }
}

//退出
fun myExit(){
    println()
    println("感谢您的使用！")
    exitProcess(0)
}

//显示操作列表
fun showOptions():Int{
    while (true){
        println("*******************")
        println("1、查询")
        println("2、存款")
        println("3、取款")
        println("4、更改密码")
        println("5、退出")
        println("*******************")
        print("请选择您的操作：")
        var op = scanner.nextInt()
        if (op in 1..5) return op else wrongtime++
        if (wrongtime > 5){
            println("错误操作次数过多，已经退出")
            exitProcess(1)
        }
    }
}

//是否继续
fun ifContinue(){
    print("是否继续？y/n")
    var op = readLine()
    if (op == "n"){
        myExit()
    }

}


