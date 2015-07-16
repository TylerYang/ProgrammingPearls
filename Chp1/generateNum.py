from random import randint
def swap(i, j):
    tmp = x[i]
    x[i] = x[j]
    x[j] = tmp
 
f = open('phone.txt','w')
x = range(10000000)


content = '';
x[10] = 8    
for i in range(0, 10000000):
    swap(i, randint(i, 10000000 - 1))
    content += str(x[i]) + '\n'
print("writing")    
f.write(content)
f.close()



   
