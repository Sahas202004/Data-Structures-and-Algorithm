//You are given n versions [1,2,3,...,n].
//You are told that after some version, all following versions are bad.
//
//You need to find the first bad version using minimum API calls.

//Test Case 1
//Input: n = 5, bad = 4
//Output: 4

//Test Case 2
//Input: n = 1, bad = 1
//Output: 1

//Test Case 3
//Input: n = 10, bad = 7
//Output: 7

//This Question is Nothing But Simple Binary Search.

public class First_Bad_Version {
    public static void main(String[] args) {
        int n = 10;
        int bad = (int) (Math.random()*20);

        int res = binarySearch(n, bad);
        System.out.println(res);
    }
//    The Function Returns the first bad version if it is available in n;
//    Else it returns -1;
//    Since it implements Binary Search, the Time Complexity is O(log n);
    static int binarySearch(int num,int bad){
//        Declare and Initialize start=0;
        int start=0;
//        Declare and Initialize end with n;
        int end=num;

//        Inside the while loop, we will be increasing the value of start
//        and decreasing the value of end based on some conditions.
//        This loop will run until the start is less than or equal to end
        while(start<=end){
//            Declare and initialize the mid with the middle index's value
//            of the array.
//            It will keep changing after each iteration
            int mid=start+(end-start)/2;

//            Conditions:-
//            The first condition checks if the middle value is greater than target.
//            If yes,then the end pointer will be re-initialized with value of middle-1
            if(mid>bad){
                end=mid-1;
            }
//            if first condition is false, then this condition is checked.
//            it checks if the middle value is less than the target.
//            if yes then the start pointer is re-initialized with value of middle+1
            else if(mid<bad){
                start=mid+1;
            }
//            if both the above conditions are false, that means our value is found
//            at middle; So return Middle;
            else{
                return mid;
            }
        }
//        There is no bad version in the range.
//        So return -1;
        return -1;
    }
}
