public class First_And_Last_Position {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,4,4,4,4,6};
        int target=4;
        int[] arr=new int[2];
        arr[0]=findFirstAndLastIndex(nums,target,true);
        if(arr[0]==-1){
            arr[1]=-1;
        }else{
            arr[1]=findFirstAndLastIndex(nums,target,false);
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    static int findFirstAndLastIndex(int[] nums,int target,boolean left){
        int index=-1;
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(nums[mid]>target){
                end=mid-1;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                index=mid;
                if(left){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return index;
    }
}
