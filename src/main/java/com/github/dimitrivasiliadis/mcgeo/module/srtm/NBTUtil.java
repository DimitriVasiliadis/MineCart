package com.github.dimitrivasiliadis.mcgeo.module.srtm;

import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.io.NBTOutputStream;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class NBTUtil {

    public static void saveNBTData(File file, CompoundTag data) throws IOException {
        try (NBTOutputStream outputStream = new NBTOutputStream(new FileOutputStream(file))) {
            outputStream.writeTag(data,1);
        }
    }


}