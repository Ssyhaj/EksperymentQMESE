import java.util.*;

/**
 * KOMPILUJE SIĘ ✓
 * DOKŁADNIE 25 BŁĘDÓW LOGICZNYCH
 * Poziom trudności: ŚREDNI
 */

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode node = (TreeNode) o;
        // BŁĄD 1: equals porównuje tylko value, nie left/right, ale hashCode uwzględnia wszystko
        return value == node.value;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }
}

class BinarySearchTree {
    private TreeNode root;
    private int size;
    
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }
    
    public void insert(int value) {
        root = insertHelper(root, value);
        size++;
    }
    
    private TreeNode insertHelper(TreeNode node, int value) {
        // BŁĄD 2: Brak obsługi duplikatów - zwiększa size mimo że element już istnieje
        if (node == null) {
            return new TreeNode(value);
        }
        
        if (value < node.value) {
            node.left = insertHelper(node.left, value);
        } else if (value > node.value) {
            node.right = insertHelper(node.right, value);
        }
        
        return node;
    }
    
    public boolean search(int value) {
        return searchHelper(root, value);
    }
    
    private boolean searchHelper(TreeNode node, int value) {
        // BŁĄD 3: Brak null-check - NPE gdy node == null
        if (node.value == value) {
            return true;
        }
        
        if (value < node.value) {
            return node.left != null && searchHelper(node.left, value);
        } else {
            return node.right != null && searchHelper(node.right, value);
        }
    }
    
    public void delete(int value) {
        root = deleteHelper(root, value);
        size--;
    }
    
    private TreeNode deleteHelper(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        
        if (value < node.value) {
            node.left = deleteHelper(node.left, value);
        } else if (value > node.value) {
            node.right = deleteHelper(node.right, value);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            
            TreeNode minNode = findMin(node.right);
            node.value = minNode.value;
            node.right = deleteHelper(node.right, minNode.value);
        }
        
        return node;
    }
    
    private TreeNode findMin(TreeNode node) {
        // BŁĄD 4: Brak walidacji czy node != null
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    public int findMax() {
        // BŁĄD 5: Brak sprawdzenia czy root != null
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }
    
    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderHelper(node.left, result);
            result.add(node.value);
            inorderHelper(node.right, result);
        }
    }
    
    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
    
    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            preorderHelper(node.left, result);
            preorderHelper(node.right, result);
        }
    }
    
    public int getHeight() {
        return getHeightHelper(root);
    }
    
    private int getHeightHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = getHeightHelper(node.left);
        int rightHeight = getHeightHelper(node.right);
        
        // BŁĄD 6: Brak obsługi integer overflow przy dodawaniu 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public int getSize() {
        return size;
    }
    
    public TreeNode getRoot() {
        // BŁĄD 7: Zwraca referencję do wewnętrznej struktury - naruszenie enkapsulacji
        return root;
    }
    
    public boolean isBalanced() {
        return isBalancedHelper(root) != -1;
    }
    
    private int isBalancedHelper(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = isBalancedHelper(node.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = isBalancedHelper(node.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        // BŁĄD 8: Integer overflow przy dodawaniu
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

class TreeAnalyzer {
    private BinarySearchTree tree;
    
    public TreeAnalyzer(BinarySearchTree tree) {
        this.tree = tree;
    }
    
    public int countLeaves() {
        return countLeavesHelper(tree.getRoot());
    }
    
    private int countLeavesHelper(TreeNode node) {
        // BŁĄD 9: Brak null-check
        if (node.left == null && node.right == null) {
            return 1;
        }
        
        int count = 0;
        if (node.left != null) {
            count += countLeavesHelper(node.left);
        }
        if (node.right != null) {
            count += countLeavesHelper(node.right);
        }
        
        return count;
    }
    
    public int sumAllValues() {
        return sumHelper(tree.getRoot());
    }
    
    private int sumHelper(TreeNode node) {
        if (node == null) return 0;
        
        // BŁĄD 10: Integer overflow przy sumowaniu
        return node.value + sumHelper(node.left) + sumHelper(node.right);
    }
    
    public boolean hasPathSum(int targetSum) {
        return hasPathSumHelper(tree.getRoot(), targetSum);
    }
    
    private boolean hasPathSumHelper(TreeNode node, int remaining) {
        // BŁĄD 11: Brak null-check na początku
        if (node.left == null && node.right == null) {
            return remaining == node.value;
        }
        
        int newRemaining = remaining - node.value;
        
        boolean leftPath = false;
        boolean rightPath = false;
        
        if (node.left != null) {
            leftPath = hasPathSumHelper(node.left, newRemaining);
        }
        if (node.right != null) {
            rightPath = hasPathSumHelper(node.right, newRemaining);
        }
        
        return leftPath || rightPath;
    }
    
    public List<Integer> findPath(int target) {
        List<Integer> path = new ArrayList<>();
        findPathHelper(tree.getRoot(), target, path);
        return path;
    }
    
    private boolean findPathHelper(TreeNode node, int target, List<Integer> path) {
        if (node == null) return false;
        
        // BŁĄD 12: Dodaje do path bez późniejszego usunięcia przy backtrackingu (dla nieudanych ścieżek)
        path.add(node.value);
        
        if (node.value == target) {
            return true;
        }
        
        if (findPathHelper(node.left, target, path) || findPathHelper(node.right, target, path)) {
            return true;
        }
        
        return false;
    }
    
    public int getDiameter() {
        int[] diameter = new int[1];
        getDiameterHelper(tree.getRoot(), diameter);
        return diameter[0];
    }
    
    private int getDiameterHelper(TreeNode node, int[] diameter) {
        if (node == null) return 0;
        
        int leftHeight = getDiameterHelper(node.left, diameter);
        int rightHeight = getDiameterHelper(node.right, diameter);
        
        // BŁĄD 13: Integer overflow przy dodawaniu wysokości
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

class BinarySearchUtils {
    
    public static int binarySearch(int[] arr, int target) {
        // BŁĄD 14: Brak walidacji czy arr != null
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }
    
    private static int binarySearchHelper(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        // BŁĄD 15: Integer overflow przy obliczaniu mid dla dużych wartości left i right
        int mid = (left + right) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchHelper(arr, target, mid + 1, right);
        } else {
            return binarySearchHelper(arr, target, left, mid - 1);
        }
    }
    
    public static int findFirstOccurrence(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static int findLastOccurrence(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            // BŁĄD 16: Integer overflow
            int mid = (left + right) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static int countOccurrences(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        if (first == -1) return 0;
        
        int last = findLastOccurrence(arr, target);
        
        // BŁĄD 17: Integer overflow przy odejmowaniu (teoretycznie możliwe dla skrajnych wartości)
        return last - first + 1;
    }
    
    public static int searchRotatedArray(int[] arr, int target) {
        // BŁĄD 18: Brak walidacji null/empty
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}

class TreeBuilder {
    
    public static BinarySearchTree fromSortedArray(int[] arr) {
        BinarySearchTree tree = new BinarySearchTree();
        
        // BŁĄD 19: Brak walidacji arr != null
        TreeNode root = sortedArrayToBST(arr, 0, arr.length - 1);
        
        // Ręczne ustawienie root (hack dla demonstracji)
        tree.insert(root.value);
        copyTree(root.left, tree);
        copyTree(root.right, tree);
        
        return tree;
    }
    
    private static TreeNode sortedArrayToBST(int[] arr, int left, int right) {
        if (left > right) return null;
        
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        
        node.left = sortedArrayToBST(arr, left, mid - 1);
        node.right = sortedArrayToBST(arr, mid + 1, right);
        
        return node;
    }
    
    private static void copyTree(TreeNode node, BinarySearchTree tree) {
        if (node != null) {
            tree.insert(node.value);
            copyTree(node.left, tree);
            copyTree(node.right, tree);
        }
    }
    
    public static BinarySearchTree mergeTrees(BinarySearchTree tree1, BinarySearchTree tree2) {
        BinarySearchTree merged = new BinarySearchTree();
        
        List<Integer> values1 = tree1.inorderTraversal();
        List<Integer> values2 = tree2.inorderTraversal();
        
        for (int val : values1) {
            merged.insert(val);
        }
        
        for (int val : values2) {
            merged.insert(val);
        }
        
        return merged;
    }
}

class TreeComparator implements Comparator<TreeNode> {
    @Override
    public int compare(TreeNode n1, TreeNode n2) {
        // BŁĄD 20: Brak null-checks dla n1 lub n2
        // BŁĄD 21: Integer overflow przy odejmowaniu
        return n1.value - n2.value;
    }
}

class RangeQuery {
    
    public static List<Integer> findRange(BinarySearchTree tree, int low, int high) {
        List<Integer> result = new ArrayList<>();
        findRangeHelper(tree.getRoot(), low, high, result);
        return result;
    }
    
    private static void findRangeHelper(TreeNode node, int low, int high, List<Integer> result) {
        // BŁĄD 22: Brak null-check
        if (node.value >= low && node.value <= high) {
            result.add(node.value);
        }
        
        if (node.left != null && node.value > low) {
            findRangeHelper(node.left, low, high, result);
        }
        
        if (node.right != null && node.value < high) {
            findRangeHelper(node.right, low, high, result);
        }
    }
    
    public static int sumRange(BinarySearchTree tree, int low, int high) {
        return sumRangeHelper(tree.getRoot(), low, high);
    }
    
    private static int sumRangeHelper(TreeNode node, int low, int high) {
        if (node == null) return 0;
        
        int sum = 0;
        
        if (node.value >= low && node.value <= high) {
            // BŁĄD 23: Integer overflow przy sumowaniu
            sum += node.value;
        }
        
        if (node.value > low) {
            sum += sumRangeHelper(node.left, low, high);
        }
        
        if (node.value < high) {
            sum += sumRangeHelper(node.right, low, high);
        }
        
        return sum;
    }
}

class TreeValidator {
    
    public static boolean isBST(BinarySearchTree tree) {
        return isBSTHelper(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isBSTHelper(TreeNode node, int min, int max) {
        if (node == null) return true;
        
        // BŁĄD 24: Nie obsługuje poprawnie przypadku gdy node.value == Integer.MIN_VALUE lub Integer.MAX_VALUE
        if (node.value <= min || node.value >= max) {
            return false;
        }
        
        return isBSTHelper(node.left, min, node.value) && 
               isBSTHelper(node.right, node.value, max);
    }
    
    public static boolean areMirrors(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        // BŁĄD 25: Brak sprawdzenia gdy tylko jeden z nich jest null
        if (n1.value != n2.value) return false;
        
        return areMirrors(n1.left, n2.right) && areMirrors(n1.right, n2.left);
    }
}

public class TreeAndBinarySearch {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            bst.insert(val);
        }
        
        System.out.println("Inorder: " + bst.inorderTraversal());
        System.out.println("Preorder: " + bst.preorderTraversal());
        System.out.println("Height: " + bst.getHeight());
        System.out.println("Size: " + bst.getSize());
        System.out.println("Balanced: " + bst.isBalanced());
        
        System.out.println("\nSearch 40: " + bst.search(40));
        System.out.println("Search 100: " + bst.search(100));
        
        TreeAnalyzer analyzer = new TreeAnalyzer(bst);
        System.out.println("\nLeaves: " + analyzer.countLeaves());
        System.out.println("Sum: " + analyzer.sumAllValues());
        System.out.println("Has path sum 140: " + analyzer.hasPathSum(140));
        System.out.println("Diameter: " + analyzer.getDiameter());
        
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\nBinary search for 5: " + BinarySearchUtils.binarySearch(sorted, 5));
        
        int[] duplicates = {1, 2, 2, 2, 3, 4, 5};
        System.out.println("First 2: " + BinarySearchUtils.findFirstOccurrence(duplicates, 2));
        System.out.println("Last 2: " + BinarySearchUtils.findLastOccurrence(duplicates, 2));
        System.out.println("Count 2: " + BinarySearchUtils.countOccurrences(duplicates, 2));
        
        int[] rotated = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Rotated search for 0: " + BinarySearchUtils.searchRotatedArray(rotated, 0));
        
        System.out.println("\nRange [30, 60]: " + RangeQuery.findRange(bst, 30, 60));
        System.out.println("Sum range [30, 60]: " + RangeQuery.sumRange(bst, 30, 60));
        
        System.out.println("\nIs BST: " + TreeValidator.isBST(bst));
        
        bst.delete(30);
        System.out.println("\nAfter deleting 30: " + bst.inorderTraversal());
    }
}