#!/bin/bash

dept_new () {
    if [ ! -f $2.txt ]; then #only if file not exist then create
        touch $2.txt
    else 
        echo Department already exist
    fi
}

dept_del () {
    if [ -f $2.txt ]; then #only if file exist then delete
        rm $2.txt
    else 
        echo Department does not exist
    fi
}

student_new () {
    
    if [ -f "$4.txt" ]; then  #checks if the dept exist
        isStd=`cat *.txt | grep -c "$2 $3 $4"` #find if the student entry exist or not
        if [ $isStd == 0 ]; then
            echo $2 $3 $4 >> $4.txt
        else
            echo Student already exist
        fi
    else 
        echo Department does not exist
    fi

}

student_del () {
    data=$2
    files=`echo *.txt`

    if [ ! -f "backup.txt" ]; then 
        touch backup.txt
    fi
    
    for file in $files 
        do
            grep -v $data $file  > backup.txt
            cat backup.txt > $file
        done
    rm backup.txt
}

type=$1
if [ $type == dept_new ]; then
    dept_new $*

elif [ $type == dept_del ]; then
    dept_del $*

elif [ $type == student_new ]; then
    student_new $*

elif [ $type == student_del ]; then
    student_del $*
fi