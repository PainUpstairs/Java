# from sklearn.linear_model import LinearRegression
import random
from turtle import color
import matplotlib.pyplot as plt
import numpy as np

t = []
for i in range(0, 900):
    t.append(i)

A  = 7.16
# smoother 
B  = -0.43
C  = 0.035
tc = 992
w  = 4.15
beta = 0.35
phi = 2.07

rho = 0.88
alpha = 0.00007
y = []
for i in t:
    t_temp = tc-i
    fi = t_temp**beta
    gi = fi*(np.cos(w*(np.log(t_temp))+phi))
    val =  np.log( A + B*fi + C*gi )
    y.append(val)

plt.plot(t,y, color='black')
plt.show()


# # for phi -> curve shape 
# for j in range( 150, 253):
#     y = []
#     phi = (j/100)


# # for B -> trend direction /slope
# for j in range( -50, 50):
#     y = []
#     B = (j/100)


# # for A -> offset/ graph shift 
# for j in range( 650, 750):
#     y = []
#     A = (j/100)

# # for C -> dk hard to say 
# for j in range( 300, 400):
#     y = []
#     C = (j/10000)


# # for W  -> controls and oscillates within a given upper and lower bound   
# for j in range( 400, 700):
#     y = []
#     w = (j/100)

# # for beta  -> increase or decreases the general slope of the curve and something weird
# for j in range( 200, 500):
#     y = []
#     beta = (j/1000)

# for phi  -> gentle change 
for j in range( 150, 250):
    y = []
    phi = (j/100)
    # print(C)

    # keep this part from below
    for i in t:
        t_temp = tc-i
        fi = t_temp**beta
        gi = fi*(np.cos(w*(np.log(t_temp))+phi))
        val =  np.log( A + B*fi + C*gi )
        y.append(val)

    for k in t :
        print(phi)
    plt.plot(t,y, color='black')
    plt.pause(0.0001)
    # plt.clf()
plt.show()



# for i in range( 10 ):
#     x = np.linspace(0,100, 100)
#     y = np.sin(x)
#     z = np.sin(y)
#     if(i%2 == 0 ):
#         plt.plot(x, y, color='black')
#     else:
#         plt.plot(x, z, color='red')
#     plt.pause(1)
# plt.show()