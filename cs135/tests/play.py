
u = 'hello'
v = 'goodbye'
s = ''

def funcA():
    
    for c in u:
        s=s+c
    for c in v:
        s += c

def nstars(n):
    '''returns a string of n stars'''
    assert n >= 0
    s = '*'*n
    return s
