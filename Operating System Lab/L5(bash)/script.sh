#!/bin/bash

# echo "all the arguments passed : $*"
# numOfArg=$#
# echo "No of argument : " $numOfArg
# echo "1st argument : $1"
# echo "2nd argument : $2"
# echo "0th argument : $0"
    #how to pass argument:
        #run this : ./script.sh a 1 2 "os lab"
        # $0 will give 0th index, means file name (./script.sh)

#---loop:

# for my_var in $*
#     do
#         echo  $my_var #print the passed agruments
#     done

# for((i=0;i<5;i++))
#     do
#         echo "$i - ${!i}" #!i means if i=1 !i = 1
#     done


#function

# foo () {
#     echo "in the function"
# }

# echo "before calling function"

# foo 

# echo "after calling function"

#passing arg to function:
# foo () {
#     echo "in the function"
#     echo "function argument : $*"
#     echo "no of arguments in the function : $#"
#     echo "1st arg in the function : $1"
# }

# echo "before calling function"

# foo a 2023 b #here is passing 3 args

# echo "after calling function"

#pass agrs from shell terminal
# foo () {
#     echo "in the function"
#     echo "function argument : $*"
#     echo "no of arguments in the function : $#"
#     echo "1st arg in the function : $1"
# }

# echo "before calling function"
# echo "from shell script args : $*";
# foo $* #here is passing args

# echo "after calling function"

#return from function:
# foo () {
#     v="v in func"
#     local m="m in func" #this variable can't be accessed outside function
# }

# echo "before calling function"

# foo #call funcion

# #access function variable out of it
# echo "access outside of function : $v"

# echo "after calling function"