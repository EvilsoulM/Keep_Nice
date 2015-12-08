//定义变量
def String author = "EvilsoulM"
def int age = 25
def String gender = "male"
def String company = "MEITUAN"
//在run中生产

def descInfo = "i am $author"//双引号""的内容则和脚本语言的处理有点像，如果字符中有$号的话，则它会$表达式先求值。
def desc = 'i am EvilsoulM'//单引号''中的内容严格对应Java中的String，不对$符号进行转义


def printlnAuthorInfo(author, age, gender, company) {//不可以直接使用定义的变量
    println "author=$author age=$age gender=$gender company=$company"
}

printlnAuthorInfo(author, age, gender, company);//run中调用 所以可以使用参数

//闭包
def authorInfoClosure = {
    String param1, int param2, String param3 ->
        println "author=$param1 age=$param2 gender=$param3"
} as Object

def noParamClosure = {
    ->
    println "author=$author age=$age gender=$gender company=$company"
} as Object

authorInfoClosure.call(author, age, gender);
noParamClosure.call();