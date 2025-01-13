public class Codec {

   public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> nodeList = new ArrayList<>(Arrays.asList(nodes));
        return deserializeHelper(nodeList);
    }

    private TreeNode deserializeHelper(List<String> nodeList) {
        if (nodeList.isEmpty()) {
            return null;
        }

        String val = nodeList.remove(0);
        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodeList);
        node.right = deserializeHelper(nodeList);
        return node;
    }
}
