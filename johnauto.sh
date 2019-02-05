echo "__   __    ____  _____ ____   ___  "
echo "\ \ / /   |  _ \| ____|  _ \ / _ \ "
echo " \ V /____| |_) |  _| | |_) | | | |"
echo "  | |_____|  _ <| |___|  __/| |_| |"
echo "  |_|     |_| \_\_____|_|    \___/ "
echo
echo
sleep 1s
echo "This is a script to automate the commands used in JOHN THE RIPPER"
sleep 1s
echo
echo "This script automates the password cracking of .ZIP files....."
sleep 1s
echo
echo "Enter the directory path of the .zip file you want to crack....."
read a
echo 
echo "Enter the directory where the wordlist is present....."
read c
echo
echo
zip2john $a > /hashpass.txt
sleep 5s
john --format=ZIP --wordlist=$c /hashpass.txt
echo
d=$(john --show /hashpass.txt | awk -F ':' '{print $2}')
echo
sleep 1s
echo "The password for the archive is....."$d

