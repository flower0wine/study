package Algorithms.ClassicAlgorithms;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @Project_Name Algorithm
 * @Author 李志
 * @Version 1.0
 * @Start_Time 2022 10 18 22:23
 * <p>
 * 哈夫曼编码
 */
public class HuffmanCoding {
    private String s;

    private int strLength;

    private TreeNode treeNode;

    public HuffmanCoding(String s) {
        this.s = s;
    }

    public HuffmanCoding() {
    }

    // 哈夫曼编码：压缩
    public byte[] encodingByHuffmanTree(String s) {
        this.s = s;
        return stringToNumber(charMapperCoding(treeNode = createHuffmanTree(calcString())));
    }

    public byte[] encodingByHuffmanTree(byte[] bytes) {
        return stringToNumber(charMapperCoding(treeNode = createHuffmanTree(calcString(bytes))), bytes);
    }

    // 哈夫曼编码：解压
    public byte[] decodingByHuffmanTree() {
        return numberToString(treeNode, s);
    }

    public byte[] decodingByHuffmanTree(byte[] bytes) {
        return numberToString(treeNode, tenRadixTransform(bytes));
    }

    private List<TreeNode> calcString() {
        byte[] bytes = s.getBytes();
        return calcString(bytes);
    }

    // 将字符串中每个字符计数存储
    private List<TreeNode> calcString(byte[] bytes) {
        List<TreeNode> list = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (int i = 0; i < bytes.length; i++) {
            if (map.get(bytes[i]) != null) {
                map.put(bytes[i], map.get(bytes[i]) + 1);// 已经存在数量加一
            } else {
                map.put(bytes[i], 1);
            }
        }
        // 遍历 map
        Set<Map.Entry<Byte, Integer>> entries = map.entrySet();
        for (Map.Entry<Byte, Integer> m : entries) {
            // 每一个元素创建节点
            list.add(new TreeNode(m.getKey(), m.getValue(), null, null));
        }
        return list;
    }

    // 字符计数后再创建对应的哈夫曼树
    private TreeNode createHuffmanTree(List<TreeNode> list) {
        while (true) {
            list.sort(new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode o1, TreeNode o2) {
                    return o1.weight - o2.weight;
                }
            });
            TreeNode t1 = list.remove(0);
            if (list.size() == 0) {
                return t1;
            }
            TreeNode t2 = list.remove(0);
            list.add(new TreeNode(null, t1.weight + t2.weight, t1, t2));
        }
    }

    // 根据创建的哈夫曼树将字符串的每个字符对应编码
    private Map<Byte, String> charMapperCoding(TreeNode treeNode) {
        Map<Byte, String> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        charMapperCoding(treeNode, map, "", stringBuilder);
        return map;
    }

    private void charMapperCoding(TreeNode treeNode, Map<Byte, String> map, String coding, StringBuilder sb) {
        if (treeNode != null) {
            StringBuilder stringBuilder = new StringBuilder(sb).append(coding);
            if (treeNode.data == null) {
                charMapperCoding(treeNode.left, map, "0", stringBuilder);
                charMapperCoding(treeNode.right, map, "1", stringBuilder);
            } else {
                map.put(treeNode.data, stringBuilder.toString());
            }
        }
    }

    // 利用生成的哈夫曼编码将字节数组转化为数字
    private byte[] stringToNumber(Map<Byte, String> map) {
        byte[] bytes = s.getBytes();
        return stringToNumber(map, bytes);
    }

    private byte[] stringToNumber(Map<Byte, String> map, byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            if (map.containsKey(b)) {
                stringBuilder.append(map.get(b));
            }
        }
        return numberToByte(stringBuilder);
    }

    // 将生成的数字转换为 byte
    private byte[] numberToByte(StringBuilder stringBuilder) {
        byte[] bytes = new byte[(stringBuilder.length() + 7) / 8];// 这里特别注意：不确定 size 的长度时的写法
        for (int i = 0, j = 0; i < stringBuilder.length(); i += 8) {
            String str;
            if (i + 8 <= stringBuilder.length()) {
                str = stringBuilder.substring(i, i + 8);
            } else {
                str = stringBuilder.substring(i);
                strLength = str.length(); // 如果是最后一个,
            }
            bytes[j++] = (byte) Integer.parseInt(twoRadixTransform(str));
        }
        return bytes;
    }

    // 将字节数组转变为只有 0 和 1 的字符串
    private String tenRadixTransform(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int temp = bytes[i];
            if (temp >= 0) {
                // 正数都需要使用 temp |= 256, 不管是否是最后一个
                temp |= 256;// 1 0000 0000
            }
            String s = Integer.toBinaryString(temp);
            if (s.length() >= 8 && (bytes.length == 1 || i != bytes.length - 1 || temp < 0)) {
                stringBuilder.append(s.substring(s.length() - 8));
            } else {
                stringBuilder.append(s.substring(s.length() - strLength));
            }
        }
        return stringBuilder.toString();
    }

    // 将只有 0 和 1 的字符串转化为 byte
    private String twoRadixTransform(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int index;
        char c;
        if (chars.length == 8 && chars[0] == '1') {
            res -= 128;
            index = 1;
        } else {
            index = 0;
        }
        for (int i = chars.length - 1; i >= index; i--) {
            c = chars[i];
            switch (c) {
                case '1': {
                    res += Integer.parseInt("" + c) * (int) Math.pow(2, chars.length - i - 1);
                    break;
                }
                case '0':
                    break;
                default: {
                    throw new RuntimeException(s + " 不是一个二进制数");
                }
            }
        }
        return "" + res;
    }

    // 利用之前编码的哈夫曼树将数字转化为字符串
    private byte[] numberToString(TreeNode treeNode, String targetStr) {
        if (treeNode == null) return null;
        char[] chars = targetStr.toCharArray();
        List<Byte> list = new ArrayList<>();
        TreeNode t = treeNode;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                if (t.left != null) {
                    t = t.left;
                } else {
                    list.add(t.data);
                    t = treeNode.left;
                }
            } else if (chars[i] == '1') {
                if (t.right != null) {
                    t = t.right;
                } else {
                    list.add(t.data);
                    t = treeNode.right;
                }
            }
        }
        if(t.data != null) list.add(t.data);
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    private static final class TreeNode {
        private Byte data;
        private int weight;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Byte data, int weight, TreeNode left, TreeNode right) {
            this.data = data;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
//        String sqy = "sunqingyangsb";
//        byte[] bytes = huffmanCoding.encodingByHuffmanTree(new byte[]{1, 2, 3, 4, 5});
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(Arrays.toString(huffmanCoding.decodingByHuffmanTree(bytes)));
//        System.out.println();


        try {
            FileInputStream fileInputStream = new FileInputStream("U://rotate_cat.jfif");
            byte[] bs = new byte[fileInputStream.available()];
            fileInputStream.read(bs);

            byte[] bytes = huffmanCoding.encodingByHuffmanTree(bs);
            System.out.println(bs.length + " == > " + bytes.length);

            FileOutputStream fileOutputStream = new FileOutputStream("U://cat.li");
            fileOutputStream.write(bytes);

            fileInputStream.close();
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            FileInputStream fileInputStream = new FileInputStream("U://cat.li");
            byte[] bs = new byte[fileInputStream.available()];
            fileInputStream.read(bs);

            byte[] bytes = huffmanCoding.decodingByHuffmanTree(bs);
            System.out.println(bs.length + " == > " + bytes.length);

            FileOutputStream fileOutputStream = new FileOutputStream("U://cat.jfif");
            fileOutputStream.write(bytes);

            fileInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
