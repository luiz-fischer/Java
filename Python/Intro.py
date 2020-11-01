print("Hello World!!") #This is a comment line
if 5 > 2:
    print("Five is greater than two!")
x = 5
y = "Hello, World!"
print(x)
print(y)
"""
THIS IS A COMMENT MULTI LINE
JUST WRITE
"""
# Variables
x = 5 # this is a variable type int
x = "Luiz" # this is a variable type str
#Legal variable names
myvar = "Luiz"
my_var = "Luiz"
_my_var = "Luiz"
myVar = "Luiz"
MYVAR = "Luiz"
myvar2 = "Luiz"
#Assign Value to Multiple Variables
x, y, z = "Orange", "Banana", "Apple"
print(x)
print(y)
print(z)
x = y = z = "Orange"
print(x)
print(y)
print(z)
#Output Variables
x = "Luiz"
print("My name is " + x)
x = "My name "
y = "Luiz"
z = x + y
print(z)
x = 5
y = 10
print(x + y)
#Global Variables
x = "Luiz"

def myFunc():
    print("My name is " + x)

myFunc()

x = "awesome"

def myfunc():
  x = "fantastic"
  print("Python is " + x)

myfunc()

print("Python is " + x) 
#The global Keyword
def myfunc():
  global x
  x = "fantastic"

myfunc()

print("Python is " + x) 

x = "awesome"

def myfunc():
  global x
  x = "fantastic"

myfunc()

print("Python is " + x) 
x = 35
y = "Luiz"
z = -87.7e100

print(type(x))
print(type(y))
print(type(z)) 
x = 1    # int
y = 2.8  # float
z = 1j   # complex

#convert from int to float:
a = float(x)

#convert from float to int:
b = int(y)

#convert from int to complex:
c = complex(x)

print(a)
print(b)
print(c)

print(type(a))
print(type(b))
print(type(c))
#RANDOM
import random

print(random.randrange(1, 10))
#Strings are Arrays

a = "Hello, World!"
print(a[1])
#SLICING 
b = "Hello, World!"
print(b[2:5]) 
a = "Hello, World!"
print(len(a))
txt = "The rain in Spain stays mainly in the plain"
x = "ain" in txt
print(x)
print(10 > 9)
print(10 == 9)
print(10 < 9) 
a = 200
b = 33

if b > a:
  print("b is greater than a")
else:
  print("b is not greater than a") 

print(bool("Hello"))
print(bool(15))

def myFunction() :
  return True

if myFunction():
  print("YES!")
else:
  print("NO!") 

x = 200
print(isinstance(x, int)) 