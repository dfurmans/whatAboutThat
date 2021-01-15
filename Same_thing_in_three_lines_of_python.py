import os

file_list = [ files for files in os.listdir() if files.endswith('.txt') == True]

[print(files.upper() + '\n')  for files in file_list]