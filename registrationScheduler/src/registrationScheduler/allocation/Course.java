package registrationScheduler.allocation;

import java.util.List;

import registrationScheduler.store.CourseAllocationInterface;
import registrationScheduler.store.Results;
import registrationScheduler.util.CoursePoolInterface;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-09-30
 * 
 */
public class Course {

	private final int noOfStudents = 80;
	private static int counter = 0;
	private static int k = 0;

	/**
	 * This method does not have a return type. When an object is 
	 * created this constructor is invoked
	 */
	public Course() {
		Logger.writeMessage("Constructor of Course class", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * This method allocates courses to the students according to their
	 * preferences. If there are not enough seats to allocate, the
	 * assignRandom() method is called.
	 * 
	 * @param studentIn
	 * @param resIn
	 * @param lineIn
	 */
	public synchronized void allocateCourses(List<Student> studentIn, List<CourseAllocationInterface> resIn, String lineIn) {

		List<Student> student = studentIn;
		List<CourseAllocationInterface> res = resIn;
		CourseAllocationInterface ci = new Results();
		Student st = new Student();
		
		String line  = lineIn;
		
		
		String[] token = line.split("\\s+");
		CoursePoolInterface obj = ObjectPool.getInstance();
		
		
		ci.setStudentName(token[0]);

		st.setPreferenceForA(Integer.parseInt(token[1]));
		st.setPreferenceForB(Integer.parseInt(token[2]));
		st.setPreferenceForC(Integer.parseInt(token[3]));
		st.setPreferenceForD(Integer.parseInt(token[4]));
		st.setPreferenceForE(Integer.parseInt(token[5]));
		st.setPreferenceForF(Integer.parseInt(token[6]));
		st.setPreferenceForG(Integer.parseInt(token[7]));

		student.add(counter, st);
		
		//Allocate course for preference 1
		for (int j = 1; j < 2; j++) {
			if (student.get(counter).getPreferenceForA() == j) {
				if (obj.borrowObject("A") < 60) {
					ci.setAssignedCourseName("A ");
					ci.setTotalAllocated(1);
					ci.setPreferenceScore(j);
					
					obj.addAveragePreferenceScore(j);
					obj.addObject("A");
					res.add(counter, ci);
				} else {
					res.add(counter,ci);
					assignRandom(student, res, counter, j, obj);
				}
				
			} else if (student.get(counter).getPreferenceForB() == j) {
				if (obj.borrowObject("B") < 60) {
					ci.setAssignedCourseName("B ");
					ci.setTotalAllocated(1);
					ci.setPreferenceScore(j);
					
					obj.addAveragePreferenceScore(j);
					obj.addObject("B");
					res.add(counter, ci);
				} else {
					res.add(counter,ci);
					assignRandom(student, res, counter, j, obj);
				}

			} else if (student.get(counter).getPreferenceForC() == j) {
				if (obj.borrowObject("C") < 60) {
					ci.setAssignedCourseName("C ");
					ci.setTotalAllocated(1);
					ci.setPreferenceScore(j);
					
					obj.addAveragePreferenceScore(j);
					obj.addObject("C");
					res.add(counter, ci);
				} else {
					res.add(counter,ci);
					assignRandom(student, res, counter, j, obj);
				}

			} else if (student.get(counter).getPreferenceForD() == j) {
				if (obj.borrowObject("D") < 60) {
					ci.setAssignedCourseName("D ");
					ci.setTotalAllocated(1);
					ci.setPreferenceScore(j);
					
					obj.addAveragePreferenceScore(j);
					obj.addObject("D");
					res.add(counter, ci);
				} else {
					res.add(counter,ci);
					assignRandom(student, res, counter, j, obj);
				}

			} else if (student.get(counter).getPreferenceForE() == j) {
				if (obj.borrowObject("E") < 60) {
					ci.setAssignedCourseName("E ");
					ci.setTotalAllocated(1);
					ci.setPreferenceScore(j);
					
					obj.addAveragePreferenceScore(j);
					obj.addObject("E");
					res.add(counter, ci);
				} else {
					res.add(counter,ci);
					assignRandom(student, res, counter, j, obj);
				}

			} else if (student.get(counter).getPreferenceForF() == j) {
				if (obj.borrowObject("F") < 60) {
					ci.setAssignedCourseName("F ");
					ci.setTotalAllocated(1);
					ci.setPreferenceScore(j);
					
					obj.addAveragePreferenceScore(j);
					obj.addObject("F");
					res.add(counter, ci);
				} else {
					res.add(counter,ci);
					assignRandom(student, res, counter, j, obj);
				}

			} else if (student.get(counter).getPreferenceForG() == j) {
				if (obj.borrowObject("G") < 60) {
					ci.setAssignedCourseName("G ");
					ci.setTotalAllocated(1);
					ci.setPreferenceScore(j);
					
					obj.addAveragePreferenceScore(j);
					obj.addObject("G");
					res.add(counter, ci);
				} else {
					res.add(counter,ci);
					assignRandom(student, res, counter, j, obj);
				}
			}
		}
		Logger.writeMessage("Entry added to Results data structure", Logger.DebugLevel.RESULT);
		counter++;
	}

	/**
	 * This method allocates courses to the students according to their
	 * preferences. If there are not enough seats to allocate, the
	 * assignRandom() method is called.
	 * 
	 * @param studentIn
	 * @param resIn
	 * @param lineIn
	 */
	public synchronized void allocateCourses1(List<Student> studentIn, List<CourseAllocationInterface> resIn) {

		List<Student> student = studentIn;
		List<CourseAllocationInterface> res = resIn;
		CourseAllocationInterface ci;
		ObjectPool obj = ObjectPool.getInstance();
		
		//Allocate courses for other preferences
		for (int j = 2; j <= 7; j++) {
			for (k = 0; k < noOfStudents; k++) {
				if (student.get(k).getPreferenceForA() == j) {
					if (obj.borrowObject("A") < 60 && res.get(k).getTotalAllocated() < 5) {
						ci = res.get(k);
						ci.setAssignedCourseName(ci.getAssignedCourseName() + "A ");
						ci.setTotalAllocated(ci.getTotalAllocated() + 1);
						ci.setPreferenceScore(ci.getPreferenceScore() + j);
						
						obj.addAveragePreferenceScore(j);
						obj.addObject("A");
						
					} else {
						assignRandom(student, res, k, j, obj);
					}

				} else if (student.get(k).getPreferenceForB() == j) {
					if (obj.borrowObject("B") < 60 && res.get(k).getTotalAllocated() < 5) {
						ci = res.get(k);
						ci.setAssignedCourseName(ci.getAssignedCourseName() + "B ");
						ci.setTotalAllocated(ci.getTotalAllocated() + 1);
						ci.setPreferenceScore(ci.getPreferenceScore() + j);
						
						obj.addAveragePreferenceScore(j);
						obj.addObject("B");
						
					} else {
						assignRandom(student, res, k, j, obj);
					}

				} else if (student.get(k).getPreferenceForC() == j) {
					if (obj.borrowObject("C") < 60 && res.get(k).getTotalAllocated() < 5) {
						ci = res.get(k);
						ci.setAssignedCourseName(ci.getAssignedCourseName() + "C ");
						ci.setTotalAllocated(ci.getTotalAllocated() + 1);
						ci.setPreferenceScore(ci.getPreferenceScore() + j);
						
						obj.addAveragePreferenceScore(j);
						obj.addObject("C");
						
					} else {
						assignRandom(student, res, k, j, obj);
					}

				} else if (student.get(k).getPreferenceForD() == j) {
					if (obj.borrowObject("D") < 60 && res.get(k).getTotalAllocated() < 5) {
						ci = res.get(k);
						ci.setAssignedCourseName(ci.getAssignedCourseName() + "D ");
						ci.setTotalAllocated(ci.getTotalAllocated() + 1);
						ci.setPreferenceScore(ci.getPreferenceScore() + j);
						
						obj.addAveragePreferenceScore(j);
						obj.addObject("D");
						
					} else {
						assignRandom(student, res, k, j, obj);
					}

				} else if (student.get(k).getPreferenceForE() == j) {
					if (obj.borrowObject("E") < 60 && res.get(k).getTotalAllocated() < 5) {
						ci = res.get(k);
						ci.setAssignedCourseName(ci.getAssignedCourseName() + "E ");
						ci.setTotalAllocated(ci.getTotalAllocated() + 1);
						ci.setPreferenceScore(ci.getPreferenceScore() + j);
						
						obj.addAveragePreferenceScore(j);
						obj.addObject("E");
						
					} else {
						assignRandom(student, res, k, j, obj);
					}

				} else if (student.get(k).getPreferenceForF() == j) {
					if (obj.borrowObject("F") < 60 && res.get(k).getTotalAllocated() < 5) {
						ci = res.get(k);
						ci.setAssignedCourseName(ci.getAssignedCourseName() + "F ");
						ci.setTotalAllocated(ci.getTotalAllocated() + 1);
						ci.setPreferenceScore(ci.getPreferenceScore() + j);
						
						obj.addAveragePreferenceScore(j);
						obj.addObject("F");
						
					} else {
						assignRandom(student, res, k, j, obj);
					}

				} else if (student.get(k).getPreferenceForG() == j) {
					if (obj.borrowObject("G") < 60 && res.get(k).getTotalAllocated() < 5) {
						ci = res.get(k);
						ci.setAssignedCourseName(ci.getAssignedCourseName() + "G ");
						ci.setTotalAllocated(ci.getTotalAllocated() + 1);
						ci.setPreferenceScore(ci.getPreferenceScore() + j);
						
						obj.addAveragePreferenceScore(j);
						obj.addObject("G");
						
					} else {
						assignRandom(student, res, k, j, obj);
					}
				}
				Logger.writeMessage("Entry added to Results data structure", Logger.DebugLevel.RESULT);
			}
		}
	}

	/**
	 * This method allocates the rest of the preferences for a student who has
	 * not got a previous preference of his/her choice.
	 * 
	 * @param student
	 * @param preference
	 * @param obj
	 */
	private synchronized void assignRandom(List<Student> studentIn, List<CourseAllocationInterface> resIn, int counterIn, int preference,CoursePoolInterface objIn) {
		
		List<Student> student = studentIn;
		List<CourseAllocationInterface> res = resIn;
		CourseAllocationInterface ci;
		CoursePoolInterface obj = objIn;
		
		//Allocate courses if preferred course is not allocated
		for (int i = preference; i <= 7; i++) {
			if (student.get(counterIn).getPreferenceForA() == preference + 1 && res.get(counterIn).getTotalAllocated() < 5 && obj.borrowObject("A") < 60) {
				
				ci = res.get(counterIn);
				ci.setAssignedCourseName(ci.getAssignedCourseName() + "A ");
				ci.setTotalAllocated(ci.getTotalAllocated() + 1);
				ci.setPreferenceScore(ci.getPreferenceScore() + preference + 1);
				
				obj.addAveragePreferenceScore(preference + 1);
				obj.addObject("A");
				
				preference++;
			} else if (student.get(counterIn).getPreferenceForB() == preference + 1 && res.get(counterIn).getTotalAllocated() < 5 && obj.borrowObject("B") < 60) {				
				ci = res.get(counterIn);
				ci.setAssignedCourseName(ci.getAssignedCourseName() + "B ");
				ci.setTotalAllocated(ci.getTotalAllocated() + 1);
				ci.setPreferenceScore(ci.getPreferenceScore() + preference + 1);
				
				obj.addAveragePreferenceScore(preference + 1);
				obj.addObject("B");
				
				preference++;
			} else if (student.get(counterIn).getPreferenceForC() == preference + 1 && res.get(counterIn).getTotalAllocated() < 5 && obj.borrowObject("C") < 60) {
				
				ci = res.get(counterIn);
				ci.setAssignedCourseName(ci.getAssignedCourseName() + "C ");
				ci.setTotalAllocated(ci.getTotalAllocated() + 1);
				ci.setPreferenceScore(ci.getPreferenceScore() + preference + 1);
				
				obj.addAveragePreferenceScore(preference + 1);
				obj.addObject("C");
				
				preference++;
			} else if (student.get(counterIn).getPreferenceForD() == preference + 1 && res.get(counterIn).getTotalAllocated() < 5 && obj.borrowObject("D") < 60) {				
				ci = res.get(counterIn);
				ci.setAssignedCourseName(ci.getAssignedCourseName() + "D ");
				ci.setTotalAllocated(ci.getTotalAllocated() + 1);
				ci.setPreferenceScore(ci.getPreferenceScore() + preference + 1);
				
				obj.addAveragePreferenceScore(preference + 1);
				obj.addObject("D");
				
				preference++;
			} else if (student.get(counterIn).getPreferenceForE() == preference + 1 && res.get(counterIn).getTotalAllocated() < 5 && obj.borrowObject("E") < 60) {				
				ci = res.get(counterIn);
				ci.setAssignedCourseName(ci.getAssignedCourseName() + "E ");
				ci.setTotalAllocated(ci.getTotalAllocated() + 1);
				ci.setPreferenceScore(ci.getPreferenceScore() + preference + 1);
				
				obj.addAveragePreferenceScore(preference + 1);
				obj.addObject("E");
				
				preference++;
			} else if (student.get(counterIn).getPreferenceForF() == preference + 1 && res.get(counterIn).getTotalAllocated() < 5 && obj.borrowObject("F") < 60) {				
				ci = res.get(counterIn);
				ci.setAssignedCourseName(ci.getAssignedCourseName() + "F ");
				ci.setTotalAllocated(ci.getTotalAllocated() + 1);
				ci.setPreferenceScore(ci.getPreferenceScore() + preference + 1);
				
				obj.addAveragePreferenceScore(preference + 1);
				obj.addObject("F");
				
				preference++;
			} else if (student.get(counterIn).getPreferenceForG() == preference + 1 && res.get(counterIn).getTotalAllocated() < 5 && obj.borrowObject("G") < 60) {				
				ci = res.get(counterIn);
				ci.setAssignedCourseName(ci.getAssignedCourseName() + "G ");
				ci.setTotalAllocated(ci.getTotalAllocated() + 1);
				ci.setPreferenceScore(ci.getPreferenceScore() + preference + 1);
				
				obj.addAveragePreferenceScore(preference + 1);
				obj.addObject("G");
				
				preference++;
			}
			Logger.writeMessage("Entry added to Results data structure", Logger.DebugLevel.RESULT);
		}
	}
	
	/**
	 * Returns string
	 * 
	 * @return given string in the function
	 */
	@Override
	public String toString() {
		return "Course [noOfStudents=" + noOfStudents + "]";
	}
}