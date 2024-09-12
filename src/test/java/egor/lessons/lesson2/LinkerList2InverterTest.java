package egor.lessons.lesson2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkerList2InverterTest {

    @Test
    void invertListTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        LinkedList2Inverter.invertList(list);

        assertThat(list.head.value).isEqualTo(3);
    }
}
