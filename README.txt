Mini-Max Sum:

Space: Worst case O(1) because the space does not increase with the size of the input, since we always only hold the same number of values. The only thing that can change size is the input
which would be held elsewhere. 

Time: Worst case O(N) because we loop through the input of size n twice, therefore it scales linearly with the size of the input. 

Weighted-Uniform Strings:

We break the stored values into: The 26 input hashmap of letters (constant), the number of temporary storing values (constant), the array of weights that we found (linear),
and the final transformation of that array into YES/NOs based on that arr and the querries (linear).
We take the worst case to be the highest growth rate based on the input, which is linear, so: 

Space: Worst case O(N)

Time: Worst case O(N) because we linearly loop through the input and the list of querries.