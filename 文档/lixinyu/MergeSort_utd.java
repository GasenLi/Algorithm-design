
public class MergeSort_utd {
	public static void merge(int a[], int start, int mid, int end)
	{
	    int[] tmp = new int[(end-start+1)];    // tmp�ǻ���2������������ʱ����
	    int i = start;            // ��1��������������
	    int j = mid + 1;        // ��2��������������
	    int k = 0;                // ��ʱ���������

	    while(i <= mid && j <= end)
	    {
	        if (a[i] <= a[j])
	            tmp[k++] = a[i++];
	        else
	            tmp[k++] = a[j++];
	    }

	    while(i <= mid)
	        tmp[k++] = a[i++];

	    while(j <= end)
	        tmp[k++] = a[j++];

	    // ��������Ԫ�أ�ȫ�������ϵ�����a�С�
	    for (i = 0; i < k; i++)
	        a[start + i] = tmp[i];

	}

	/*
	 * �鲢����(��������)
	 *
	 * ����˵����
	 *     a -- �����������
	 *     start -- �������ʼ��ַ
	 *     endi -- ����Ľ�����ַ
	 */
	public static void merge_sort_up2down(int a[], int start, int end)
	{
	    if(a==null || start >= end)
	        return ;

	    int mid = (end + start)/2;
	    merge_sort_up2down(a, start, mid); // �ݹ�����a[start...mid]
	    merge_sort_up2down(a, mid+1, end); // �ݹ�����a[mid+1...end]

	    // a[start...mid] �� a[mid...end]����������ռ䣬
	    // �����������һ������ռ�a[start...end]
	    merge(a, start, mid, end);
	}
	
	public static void main(String[] args) {
        int[] a = new int[]{4, 3, 7, 6, 1, 2, 5, 8, 3};
        merge_sort_up2down(a, 0, a.length-1);
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + "��");
        }
    }

}
