package ActivityDiagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestActivityDiagram {

    @Test
    public void testCreateDiagram() {
        ActivityDiagram diagram = new ActivityDiagram("Test Diagram");

        assertNotNull(diagram);
        assertTrue(diagram.toString().contains("Test Diagram"));
    }

    @Test
    public void testAddNodeAndFlow() {
        ActivityDiagram diagram = new ActivityDiagram("Test Diagram");

        diagram.addNode("1", INodeTypes.START, "Start");
        diagram.addNode("2", "action", "Action");
        diagram.addNode("3", INodeTypes.END, "End");

        diagram.addFlow("1", "2");
        diagram.addFlow("2", "3");

        String result = diagram.toString();

        // Pastikan output berisi simbol dan node yang benar
        assertTrue(result.contains("(*)"));
        assertTrue(result.contains("[Action]"));
        assertTrue(result.contains("(/)"));
        assertTrue(result.contains("->"));
    }

    @Test
    public void testDecisionNode() {
        ActivityDiagram diagram = new ActivityDiagram("Decision Test");

        diagram.addNode("1", INodeTypes.DECISION, "Check");

        String result = diagram.toString();

        assertTrue(result.contains("<>"));
    }

    @Test
    public void testForkNode() {
        ActivityDiagram diagram = new ActivityDiagram("Fork Test");

        diagram.addNode("1", INodeTypes.FORK, "Fork");

        String result = diagram.toString();

        assertTrue(result.contains("==="));
    }

    @Test
    public void testToStringDoesNotThrow() {
        ActivityDiagram diagram = new ActivityDiagram("Safe Test");

        diagram.addNode("1", INodeTypes.START, "Start");

        assertDoesNotThrow(diagram::toString);
    }

    // @Test
    // public void IntentionalError(){
    //     asssertEquals(1, 2); // This test is intentionally designed to fail
    // }
}