package stackppractice

fun main(){
    println("h((e))llo(world)()".checkBalanceParentheses())
    println("h((e)llo(world)()".checkBalanceParentheses())
}


fun String.checkBalanceParentheses():Boolean{
    val stack = StackImpl<Char>()
    for (ch in this){
        when(ch){
            '(' -> stack.push(ch)
            ')' -> if(stack.isEmpty){
                return false
            }else {
                stack.pop()
            }
        }
    }
    return stack.isEmpty
}