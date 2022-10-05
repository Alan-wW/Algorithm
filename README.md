# Algorithm
Algorithm

# 二分查找

## 基本二分模板(有序数组找目标值)

> 二分搜索经典模板，注意以下三点

* 循环退出条件，注意是 low <= high，⽽不是 low < high
* mid 的取值，mid = low + (high - low) >> 1 `目的在于防止数值溢出`
* low 和 high 的更新。low = mid + 1，high = mid - 1

~~~java
//找到目标值所在下标.找不到返回-1
    public static int binarySearchMatrix(int[] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        //循环退出条件 low > high
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                low = mid - 1;
            }else if(nums[mid] < target){
                high = mid + 1;
            }
        }
        return -1;
    }
~~~



## 查找第⼀个与 target 相等的元素

```java
//找到目标值第一次出现时得下标
public static int binarySearchFirstMatrix(int[] nums,int target){
    int low = 0;
    int high = nums.length - 1;
    //循环退出条件1low > high
    while(low <= high){
        int mid = low + ((high - low) >> 1);
        if(nums[mid] == target){
            //收缩右边界在[low,mid - 1]区间内继续查找
            high = mid - 1;
        }else if(nums[mid] > target){
            low = mid - 1;
        }else if(nums[mid] < target){
            high = mid + 1;
        }
    }
    if(low >= nums.length || nums[low] != target){
        return -1;
    }
    return low;
}
```

## 查找最后⼀个与 target 相等的元素 

```java
//找到目标值最后一次出现时得下标
public static int binarySearchLastMatrix(int[] nums,int target){
    int low = 0;
    int high = nums.length - 1;
    //循环退出条件1low > high
    while(low <= high){
        int mid = low + ((high - low) >> 1);
        if(nums[mid] == target){
            //收缩左边界在[mid + 1,high]区间内继续查找
            low = mid + 1;
        }else if(nums[mid] > target){
            high = mid - 1;
        }else if(nums[mid] < target){
            low = mid + 1;
        }
    }
    //边界条件
    if(high < 0 || nums[high] != target){
        return -1;
    }
    return high;
}
```

# 二叉树的遍历

## 前序遍历

### 递归写法

~~~java
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}
~~~

### 迭代写法(模拟递归栈)

~~~java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }
}
~~~

## 中序遍历

### 递归写法

~~~java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return res;
        }
        while(root != null || !stack.isEmpty()){
            while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        res.add(root.val);
        root = root.right;
        }
        return res;
    }
}
~~~



### 迭代写法

~~~java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return res;
        }
        while(root != null || !stack.isEmpty()){
            //因为中序遍历顺序是左根右，因此先将根节点和左子树压栈
            while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        res.add(root.val);
        root = root.right;
        }
        return res;
    }
}
~~~

## 后续遍历

### 递归写法

~~~java
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}
~~~

## 层次遍历

~~~java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return new int[]{};
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
~~~

# 一维前缀和

~~~java
S[i] = a[1] + a[2] + ... + a[i] //i从1开始
a[l] + ... + a[r] = s[r] - s[l - 1]
~~~

# 二维前缀和

~~~java
S[i,j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + a[i][j]
x(x1,y1),x(x2,y2) = S[x2,y2] - S[x2,y1-1] - S[x1-1,y2] + S[x1-1,y1-1]
~~~

# 差分数组

1. O(1)时间内对[l,r]加上任意一个数c

   ```java
   b[l] += c
   b[r + 1] -= c
   ```

   

# 数学思想

## 同余定理

> 如果要使两者相除k相减为整数，需要满足二者对k取余相同

# Kmp算法

~~~java
 public boolean kmp(String S,String P){
        char[] s = new char[S.length() + 1];
        char[] p = new char[P.length() + 1];

        //模式串长度
        int n = P.length();
        //总串长度
        int m = S.length();

        for(int i = 1;i <= m;i++){
            s[i] = S.charAt(i - 1);
        }
        for(int i = 1;i <= n;i++){
            p[i] = P.charAt(i - 1);
        }
        //构造prefix数组
        int[] prefix = new int[n + 1];
        for(int i = 2,j = 0;i <= n;i++){
            while (j != 0 && p[i] != p[j + 1]){
                j = prefix[j];
            }
            if(p[i] == p[j + 1]){
                j++;
            }
            prefix[i] = j;
        }
        //kmp匹配
        for(int i = 1,j = 0;i <= m;i++){
            while(j != 0 && s[i] != p[j + 1]){
                j = prefix[j];
            }
            if(s[i] == p[j + 1]){
                j++;
            }
            if(j == n){
                return true;
            }
        }
        return false;
    }
~~~

# Tire树

~~~java
class Trie {
    int N = 100010	; // 直接设置为十万级
    int[][] trie;
    int[] count;
    int index;

    public Trie() {
        trie = new int[N][26];
        count = new int[N];
        index = 0;
    }
    //插入
    public void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) trie[p][u] = ++index;
            p = trie[p][u];
        }
        count[p]++;
    }
    //查询一个字符串是否存在
    public boolean search(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) return false;
            p = trie[p][u];
        }
        return count[p] != 0;
    }
    //判断树中是否有前缀为s的字符串
    public boolean startsWith(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) return false;
            p = trie[p][u];
        }
        return true;
    }
}
~~~

# 并查集

```java
class UF {
    private int count;
    private int[] parent;
    private int[] size;
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return ;
        // 平衡性优化
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        this.count--;
    }
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    public int count() {
        return this.count;
    }
    private int find(int x) {
        while (x != parent[x]) {
            // 路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}


```



# 整数二分

~~~java
bool check(int x) {/* ... */} // 检查x是否满足某种性质

// 区间[l, r]被划分成[l, mid]和[mid + 1, r]时使用：
int bsearch_1(int l, int r)
{
    while (l < r)
    {
        int mid = l + r >> 1;
        if (check(mid)) r = mid;    // check()判断mid是否满足性质
        else l = mid + 1;
    }
    return l;
}
// 区间[l, r]被划分成[l, mid - 1]和[mid, r]时使用：
int bsearch_2(int l, int r)
{
    while (l < r)
    {
        int mid = l + r + 1 >> 1;
        if (check(mid)) l = mid;
        else r = mid - 1;
    }
    return l;
}
~~~

# 位运算

> 求n的二进制表示第k位是几

1. 先将第K位移到最后一位 n>>k
2. 看个位是几 n&1
3. =>  n >> k & 1

> Lowbit(x) 返回x的最后一位1  eg: 10100 => 100

1. Lowbit(x) = x &-x

# 离散化

```java
alls = alls.stream().distinct().sorted().collect(Collectors.toList());
```

# 链表

## 数组模拟单链表

> 头插

```java
// head存储链表头，e[]存储节点的值，ne[]存储节点的next指针，idx表示当前用到了哪个节点
int head, e[N], ne[N], idx;

// 初始化
void init()
{
    head = -1;
    idx = 0;
}

// 在链表头插入一个数a
void insert(int a)
{
    e[idx] = a, ne[idx] = head, head = idx ++ ;
}

// 将头结点删除，需要保证头结点存在
void remove()
{
    head = ne[head];
}
```



## 数组模拟双链表

```java
// e[]表示节点的值，l[]表示节点的左指针，r[]表示节点的右指针，idx表示当前用到了哪个节点
int e[N], l[N], r[N], idx;

// 初始化
void init()
{
    //0是左端点，1是右端点
    r[0] = 1, l[1] = 0;
    idx = 2;
}

// 在节点a的右边插入一个数x
void insert(int a, int x)
{
    e[idx] = x;
    l[idx] = a, r[idx] = r[a];
    l[r[a]] = idx, r[a] = idx ++ ;
}

// 删除节点a
void remove(int a)
{
    l[r[a]] = l[a];
    r[l[a]] = r[a];
}
```

# 最小生成树

## Prim

### 朴素版Prim(O(n^2))

> 适用于稠密图

### 堆优化版Prim(O(mlogn))



## Kruskal

> 适用于稀疏图

# 二分图

## 染色法(O(n + m))



## 匈牙利算法(O(mn))



# 倍增乘法

```java
long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) ans += a;
            k >>= 1;
            a += a;
        }
        return ans;
    }
```

