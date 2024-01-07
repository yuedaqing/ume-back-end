package com.yue.netty.util;

import io.netty.buffer.ByteBuf;

import static io.netty.buffer.ByteBufUtil.appendPrettyHexDump;
import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.NEWLINE;

public class ByteBufUtil {
    public static void log(ByteBuf byteBuf) {
        int length = byteBuf.readableBytes();
        int rows = length / 16 + (length % 15 == 0 ? 0 : 1) + 4;
        StringBuilder buf = new StringBuilder(rows * 80 * 2)
                .append("read index:").append(byteBuf.readerIndex())
                .append("write index:").append(byteBuf.writerIndex())
                .append(" capacity:").append(byteBuf.capacity())
                .append(NEWLINE);
        appendPrettyHexDump(buf, byteBuf);
        System.out.println(buf.toString());
    }
}
