Dan Needham
Thought Questions:

1. The solution to the 15 block problem, as printed by my program, is as follows:

Tower number one consists of blocks: <Vector: 4.0 5.0 6.0 10.0 11.0 12.0 13.0>

Height = 20.23411306140849

Tower number two consists of blocks: <Vector: 1.0 2.0 3.0 7.0 8.0 9.0 14.0 15.0>

Height = 20.235083538734113

2. My program takes 14.315 seconds to print the solution to the 20 block problem. I predict that the time to solve the problem will double for every additional block,as there will be twice as many subsets.

Therefore the 21 block problem will be about 28 seconds. The actual time was 29.115 seconds. Based on this theory I would predict that the 25 block problem will take about 8 minutes to run. The observed time this program took to run was 9 minutes and 26.709 seconds, which is fairly consistent with my prediction. 

Based on this the 40 block problem would take about 73 hours, and the 50 block program would take about 74,565 hours.

3. If we wanted to implement to implement a random subset iterator that only ran for 1 second, we would want to iterate through about 2^16 subsets. This is based on the fact that the 20 block problem took about 15 seconds. I would implement the random aspect by generating the double that represents the subset randomly. I would do this in a loop that repeated the task 2^16 times.    
