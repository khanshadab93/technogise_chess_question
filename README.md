1. Prerequisites
Before starting, ensure you have the following software installed:

Java Development Kit (JDK) (Version 8 or above recommended)
  Download: Oracle JDK
  Confirm installation:
    java -version
    
IntelliJ IDEA (Community or Ultimate Edition)

Git (for cloning the repository)
Download: Git Official Page
Confirm installation:
    git --version
__________________________________________________________________
2. Clone the Repository
    git clone https://github.com/khanshadab93/technogise_chess_question.git
__________________________________________________________________
3. Import the Project into IntelliJ IDEA
    Open IntelliJ IDEA.
    Click on Open and navigate to the project directory where you cloned the repository.
    Select the root folder of the project and click OK.
    IntelliJ will recognize the project structure and open it.
__________________________________________________________________
4. Configure the Project SDK
__________________________________________________________________
5. Build the Project
__________________________________________________________________
6. Open the main class file (ChessSimulation.java) in the src directory and RUN the java file.
__________________________________________________________________
7. Verify the Output
       Input: Pawn, G1 | Output: G2
       Input: King, D5 | Output: C4, D4, E4, C5, E5, C6, D6, E6
       Input: Queen, E4 | Output: E3, E2, E1, F4, G4, H4, E5, E6, E7, E8, D4, C4, B4, A4, D3, C2, B1, F3, G2, H1, D5, C6, B7, A8, F5, G6, H7

______________________________________________________________________________________________________________________________________________________________________
Running Unit tests
1. Add the junit.junit5.engine file to the File>Project Structure>Libraries
2. Resolve the import errors (if any) in the java class ChessSimulationTest
3. Run the test case File ChessSimulationTest
