package io.reactiverse.pgclient.codec.simple;

import io.reactiverse.pgclient.Row;
import io.reactiverse.pgclient.Tuple;
import io.reactiverse.pgclient.codec.SimpleQueryDataTypeCodecTestBase;
import io.vertx.ext.unit.TestContext;
import org.junit.Test;

import java.util.UUID;

public class UUIDTypeTest extends SimpleQueryDataTypeCodecTestBase {
  @Test
  public void testUUID(TestContext ctx) {
    UUID expected = UUID.fromString("50867d3d-0098-4f61-bd31-9309ebf53475");
    testDecodeGeneric(ctx, "50867d3d-0098-4f61-bd31-9309ebf53475", "UUID", "uuid", Tuple::getUUID, Row::getUUID, expected);
  }

  @Test
  public void testDecodeUUIDArray(TestContext ctx) {
    testDecodeGenericArray(ctx, "ARRAY ['6f790482-b5bd-438b-a8b7-4a0bed747011' :: UUID]", "UUID", Tuple::getUUIDArray, Row::getUUIDArray, uuid);
  }
}
