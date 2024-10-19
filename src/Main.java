//ARRAY----------------------------------------------------------------------------------
////704. Binary Search
//public class Main {
//    public static void main(String[] args){
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 2;
//        System.out.println(new Main().search(nums, target));
//    }
//
//    public int search(int[] nums, int target){
//        int left = 0, right = nums.length;
//        while(left < right){
//            int mid = left + ((right - left) >> 1);
//            if (nums[mid] == target){
//                return mid;
//            }
//            else if (nums[mid] < target){
//                left = mid + 1;
//            }
//            else{
//                right = mid;
//            }
//        }
//        return -1;
//    }
//}

////27. Remove Element
//public class Main{
//    public static void main(String[] args){
//        int[] nums = {0,1,2,2,3,0,4,2};
//        int val = 2;
//        System.out.println(new Main().removeElement(nums, val));
//    }
//
//    public int removeElement(int[] nums, int val){//two pointers
//        int slowIndex = 0;
//        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++){
//            if (nums[fastIndex] != val){
//                nums[slowIndex++] = nums[fastIndex];
//            }
//        }
//        return slowIndex;
//    }
//}

////977. Squares of a Sorted Array
//import java.util.Arrays;
//
//public class Main{
//    public static void main(String[] args){
//        int[] nums = {-7,-3,2,3,11};
//        System.out.println(Arrays.toString(new Main().sortedSquares(nums)));
//    }
//
//    public int[] sortedSquares(int[] nums){
//        int l = 0, r = nums.length - 1, j = nums.length - 1;
//        int[] res = new int[nums.length];
//        while (l <= r){
//            if (nums[l] * nums[l] > nums[r] * nums[r]) {
//                res[j--] = nums[l] * nums[l++];
//            }else{
//                res[j--] = nums[r] * nums[r--];
//            }
//        }
//        return res;
//    }
//}

////209. Minimum Size Subarray Sum
//public class Main{
//    public static void main(String[] args){
//        int target = 11;
//        int[] nums = {1,1,1,1,1,1,1,1};
//        System.out.println(new Main().minSubArrayLen(target, nums));
//    }
//
//    public int minSubArrayLen(int target, int[] nums){//sliding window
//        int l = 0;//start point of the window
//        int sum = 0;//sum of the window
//        int res = Integer.MAX_VALUE;//2^31-1
//        for (int r = 0; r < nums.length; r++){//r is end point of the window
//            sum += nums[r];
//            while (sum >= target) {
//                res = Math.min(res, r - l + 1);
//                sum -= nums[l++];
//            }
//        }
//        return res == Integer.MAX_VALUE ? 0 : res;
//    }
//}

////59. Spiral Matrix II
//import java.util.Arrays;
//public class Main{
//    public static void main(String[] args){
//        System.out.println(Arrays.deepToString(new Main().generateMatrix(1)));
//    }
//
//    public int[][] generateMatrix(int n){//simulation
//        int[][] res = new int[n][n];
//        int startX = 0, startY = 0;//start point of every loop
//        int offset = 1;//to modify the length of sides in every loop
//        int count = 1;//numbers to be filled in the matrix
//        int loop = 1;//current loop number
//        int i, j;// i and j are row and column indices respectively
//        while(loop <= n/2){
//            for (j = startY; j < n - offset; j++){//top
//                res[startX][j] = count++;
//            }
//            for (i = startX; i < n - offset; i++){//right
//                res[i][j] = count++;
//            }
//            for (; j > startY; j--){//bottom
//                res[i][j] = count++;
//            }
//            for (; i > startX; i--){//left
//                res[i][j] = count++;
//            }
//            startX++;
//            startY++;
//            offset++;
//            loop++;
//        }
//        if (n % 2 == 1){
//            res[startX][startY] = count;
//        }
//        return res;
//    }
//}

////58. 区间和（https://kamacoder.com/problempage.php?pid=1070）
//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        int[] p = new int[n];//array for prefix sums
//        int preSum = 0;
//
//        //Store input values and calculate prefix sums:
//        for (int i = 0; i < n; i++){
//            nums[i] = scanner.nextInt();
//            preSum += nums[i];
//            p[i] = preSum;
//        }
//
//        //Input intervals and calculate their sums
//        while (scanner.hasNextInt()){
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int sum;
//            if(a == 0){
//                sum = p[b];
//            }else{
//                sum = p[b] - p[a - 1];
//            }
//            System.out.println(sum);
//        }
//
//        scanner.close();
//    }
//}

////44. 开发商买土地（https://kamacoder.com/problempage.php?pid=1044）
//import java.util.Scanner;
//public class Main{
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int sum = 0;
//        int[][] nums = new int[n][m];
//
//        //Enter the value of each block:
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < m; j++){
//                nums[i][j] = scanner.nextInt();
//                sum += nums[i][j];
//            }
//        }
//
//        //Calculate the row sums:
//        int[] rowSums = new int[n];
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < m; j++) {
//                rowSums[i] += nums[i][j];
//            }
//        }
//
//        //Calculate the column sums:
//        int[] colSums = new int[m];
//        for (int j = 0; j < m; j++){
//            for (int i = 0; i < n; i++){
//                colSums[j] += nums[i][j];
//            }
//        }
//
//        //Calculate prefix sums vertically and horizontally, and find the result we want:
//        int result = Integer.MAX_VALUE;
//        int verPreSum = 0;
//        for (int i = 0; i < n; i++){
//            verPreSum += rowSums[i];
//            result = Math.min(result, Math.abs(sum - 2 * verPreSum));
//        }
//        int horPreSum = 0;
//        for (int j = 0; j < m; j++){
//            horPreSum += colSums[j];
//            result = Math.min(result, Math.abs(sum - 2 * horPreSum));
//        }
//
//        System.out.println(result);
//        scanner.close();
//    }
//}


//LINKED LIST---------------------------------------------------------------------
////203. Remove Linked List Elements
//public class Main{
//    public static void main(String[] args){
//        int[] nums = {7,7,7,7};
//        int val = 7;
//        ListNode dumHead = new ListNode();
//        ListNode curr = dumHead;
//        for (int num : nums) {
//            curr.next = new ListNode(num);
//            curr = curr.next;
//        }
//        ListNode head = new Main().removeElements(dumHead.next, val);
//        while(head != null){
//            System.out.print(head.val+"  ");
//            head = head.next;
//        }
//    }
//
////    //In normal way:
////    public ListNode removeElements(ListNode head, int val){
////        //Head node:
////        while (head != null && head.val == val){
////            head = head.next;
////        }
////
////        //Other nodes:
////        ListNode curr = head;
////        while (curr != null && curr.next != null) {
////            if (curr.next.val == val){
////                curr.next = curr.next.next;
////            }else{
////                curr = curr.next;
////            }
////        }
////
////        return head;
////    }
//
////    //In recursive way:
////    public ListNode removeElements(ListNode head, int val){
////        //Base case:
////        if (head == null){
////            return null;
////        }
////
////        //Recursive case:
////        if (head.val == val){
////            return removeElements(head.next, val);
////        }else{
////            head.next = removeElements(head.next, val);
////            return head;
////        }
////    }
//
//    //Using a dummy head node:
//    public ListNode removeElements(ListNode head, int val){
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//
//        ListNode curr = dummy;
//        while (curr.next != null){
//            if (curr.next.val == val){
//                curr.next = curr.next.next;
//            }else{
//                curr = curr.next;
//            }
//        }
//        return dummy.next;
//    }
//}

////707. Design Linked List
//class MyLinkedList{
//    int size;
//    ListNode dumHead; //dummy head node
//
//    public MyLinkedList(){
//        size = 0;
//        dumHead = new ListNode(0);
//    }
//
//    public int get(int index){
//        if (index > size - 1){
//            return -1;
//        }
//        ListNode cur = dumHead;
//        for (int i = 0; i <= index; i++){
//            cur = cur.next;
//        }
//        return cur.val;
//    }
//
//    public void addAtHead(int val){
//        ListNode toAdd = new ListNode(val);
//        toAdd.next = dumHead.next;
//        dumHead.next = toAdd;
//        size++;
//    }
//
//    public void addAtTail(int val){
//        ListNode toAdd = new ListNode(val);
//        ListNode cur = dumHead;
//        while(cur.next != null){
//            cur = cur.next;
//        }
//        cur.next = toAdd;
//        size++;
//    }
//
//    public void addAtIndex(int index, int val){
//        if (index > size){return;}
//        ListNode pred = dumHead;
//        for (int i = 0; i < index; i++){
//            pred = pred.next;
//        }
//        ListNode toAdd = new ListNode(val);
//        toAdd.next = pred.next;
//        pred.next = toAdd;
//        size++;
//    }
//
//    public void deleteAtIndex(int index){
//        if (index >= size) {return;}
//        ListNode pred = dumHead;
//        for (int i = 0; i < index; i++){
//            pred = pred.next;
//        }
//        pred.next = pred.next.next;
//        size--;
//    }
//}
//
//public class Main{
//    public static void main(String[] args){
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//        ListNode cur = myLinkedList.dumHead;
//        while (cur.next != null){
//            System.out.print(cur.next.val + "  ");
//            cur = cur.next;
//        }
//        System.out.println();
//        int out = myLinkedList.get(1);              // return 2
//        System.out.println(out);
//        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
//        cur = myLinkedList.dumHead;
//        while (cur.next != null){
//            System.out.print(cur.next.val + "  ");
//            cur = cur.next;
//        }
//        System.out.println();
//        out = myLinkedList.get(1);              // return 3
//        System.out.println(out);
//    }
//}

////206. Reverse Linked List
//public class Main {
//    public static void main(String[] args){
//        int[] nums = {1,2,3,4,5};
//        ListNode dumHead = new ListNode();
//        ListNode curr = dumHead;
//        for (int num : nums) {
//            curr.next = new ListNode(num);
//            curr = curr.next;
//        }
//        curr = new Main().reverseList(dumHead.next);
//        while (curr != null){
//            System.out.print(curr.val + " ");
//            curr = curr.next;
//        }
//    }
////    //Two pointers:
////    public ListNode reverseList(ListNode head){
////        ListNode pre = null;
////        ListNode cur = head;
////        ListNode tmp = null;
////        while(cur != null){
////            tmp = cur.next;
////            cur.next = pre;
////            pre = cur;
////            cur = tmp;
////        }
////        return pre;
////    }
//
//    //Recursion:
//    public ListNode reverseList(ListNode head) {
//        return reverse(null, head);
//    }
//    private ListNode reverse (ListNode pre, ListNode cur){
//        //Base case:
//        if (cur == null){
//            return pre;
//        }
//
//        //Recursive case:
//        ListNode tmp = cur.next;
//        cur.next = pre;
//        return reverse(cur, tmp);
//    }
//}

//24. Swap Nodes in Pairs
public class Main{
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        ListNode dumHead = new ListNode();
        ListNode curr = dumHead;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        curr = new Main().swapPairs(dumHead.next);
        while (curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

//    public ListNode swapPairs(ListNode head){
//        ListNode dummy = new ListNode(0, head);
//        ListNode cur = dummy;
//        while (cur.next != null && cur.next.next != null){
//            ListNode node1 = cur.next;
//            ListNode node2 = cur.next.next;
//            cur.next = node2;
//            node1.next = node2.next;
//            node2.next = node1;
//            cur = cur.next.next;
//        }
//        return dummy.next;
//    }

    //Recursion:
    public ListNode swapPairs(ListNode head){
        //Base case:
        if (head == null || head.next == null){
            return head;
        }

        //Recursive case:
        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next);
        next.next = head;
        head.next = newNode;

        return next;
    }
}


















