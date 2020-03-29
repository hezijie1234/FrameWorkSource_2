package com.zijie.frameworksource_2.serial_demo_2_14;

import com.google.protobuf.InvalidProtocolBufferException;
import com.zero.xuliehuademo.protobuf._StudentSerializable;

import java.util.Arrays;

public class TestProto {

    public static void main(String[] args) {
        byte[] bs = serialize();
        System.out.println(Arrays.toString(bs));
        //反序列化
        _StudentSerializable._Student student = deserialize(bs);
        System.out.println(student);
    }

public static byte[] serialize(){
    _StudentSerializable._Course.Builder courseBuild = _StudentSerializable._Course.newBuilder().setName("语文").setScore(67.5f);
    _StudentSerializable._Student.Builder builder = _StudentSerializable._Student.newBuilder().setName("和字节").setAge(17).setSax("男").addCourses(courseBuild);
    _StudentSerializable._Student build = builder.build();
    return build.toByteArray();

}

    public static _StudentSerializable._Student deserialize(byte[] bs) {
        try {
            return _StudentSerializable._Student.parseFrom(bs);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return null;
    }
}
