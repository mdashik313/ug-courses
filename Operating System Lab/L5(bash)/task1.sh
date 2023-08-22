#!/bin/bash

#task : how many vawels are in line 7 of file.txt

line=`head -7 file.txt | tail -1`
#echo $line
#count=`echo $line | grep -E -i -c "[aeiou]" | wc -l`
count=`echo $line | grep -E -i -o "[aeiou]" | wc -l`
echo $count         
                # -c give hom many lines is matched, to find how many letter is matched                              
                    # '-E means using regular expression'
                    # '-i means case insensative Capital/Smaller'
                    # '-o output the characters which is matched'
                    # 'wc -l will count the matched result and gives the count'