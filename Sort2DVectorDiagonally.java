// Given a 2D vector of NxM integers. The task is to sort the elements of the vectors diagonally 
// from top-left to bottom-right in decreasing order.

// Input: arr[][] = { { 10, 2, 3 }, { 4, 5, 6 }, {7, 8, 9 } } 
// Output: 
// 10 6 3 
// 8 9 2 
// 7 4 5
// Input: arr[][] = { { 10, 2, 43 }, { 40, 5, 16 }, { 71, 8, 29 }, {1, 100, 5} } 
// Output: 
// 29 16 43 
// 40 10 2 
// 100 8 5 
// 1 71 5 


import java.io.*;
import java.util.*;

class Sort2DVectorDiagonally {
	public static void
	diagonalSort(ArrayList<ArrayList<Integer> > mat) {
		int row = mat.size();
		int col = mat.get(0).size();
		ArrayList<ArrayList<Integer> > Neg
			= new ArrayList<ArrayList<Integer> >();
		ArrayList<ArrayList<Integer> > Pos
			= new ArrayList<ArrayList<Integer> >();

		int i, j;

		for (i = 0; i < row; i++) {
			ArrayList<Integer> temp
				= new ArrayList<Integer>();
			Neg.add(temp);
		}

		for (j = 0; j < col; j++) {
			ArrayList<Integer> temp
				= new ArrayList<Integer>();
			Pos.add(temp);
		}
		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				if (j < i) {
					Neg.get(i - j).add(mat.get(i).get(j));
				}
				else if (i < j) {
					Pos.get(j - i).add(mat.get(i).get(j));
				}
				else {
					Pos.get(0).add(mat.get(i).get(j));
				}
			}
		}
		for (i = 0; i < row; i++) {
			Collections.sort(Neg.get(i));
			;
		}
		for (i = 0; i < col; i++) {
			Collections.sort(Pos.get(i));
			;
		}

		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				if (j < i) {
					int d = i - j;
					int l = Neg.get(d).size();
					mat.get(i).set(j,
								Neg.get(d).get(l - 1));
					Neg.get(d).remove(l - 1);
				}
				else if (i < j) {
					int d = j - i;
					int l = Pos.get(d).size();
					mat.get(i).set(j,
								Pos.get(d).get(l - 1));
					Pos.get(d).remove(l - 1);
				}
				else {
					int l = Pos.get(0).size();
					mat.get(i).set(j,
								Pos.get(0).get(l - 1));
					Pos.get(0).remove(l - 1);
				}
			}
		}
		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				System.out.print(mat.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer> > arr
			= new ArrayList<ArrayList<Integer> >();
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(10);
		row1.add(2);
		row1.add(3);
		arr.add(row1);

		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(4);
		row2.add(5);
		row2.add(6);
		arr.add(row2);

		ArrayList<Integer> row3 = new ArrayList<Integer>();
		row3.add(7);
		row3.add(8);
		row3.add(9);
		arr.add(row3);

		diagonalSort(arr);

	}
}
