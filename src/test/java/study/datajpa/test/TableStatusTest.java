package study.datajpa.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TableStatusTest {

    private TableStatus selectFromOriginTable(){
        return TableStatus.Y;
    }

    @Test
    public void origin테이블에서_조회한_데이터를_다른_2테이블에_등록한다() throws Exception {
        //given
        TableStatus origin = selectFromOriginTable();

        //then
        String table1Value = origin.getTable1Value();
        boolean table2Value = origin.isTable2Value();

        assertThat(origin).isEqualTo(TableStatus.Y);
        assertThat(table1Value).isEqualTo("1");
        assertThat(table2Value).isEqualTo(true);
    }

}