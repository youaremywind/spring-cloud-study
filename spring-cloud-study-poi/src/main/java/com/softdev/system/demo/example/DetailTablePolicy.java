package com.softdev.system.demo.example;

import java.math.BigInteger;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.policy.DynamicTableRenderPolicy;
import com.deepoove.poi.policy.MiniTableRenderPolicy;
import com.deepoove.poi.util.TableTools;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;

/**
 * 付款通知书 明细表格的自定义渲染策略<br/>
 * 1. 填充货品数据 <br/>
 * 2. 填充人工费数据 <br/>
 * @author Sayi
 * @version
 */
public class DetailTablePolicy extends DynamicTableRenderPolicy {

    // 货品填充数据所在行数
    int goodsStartRow = 1;
//    // 人工费填充数据所在行数
//    int laborsStartRow = 5;

    @Override
    public void render(XWPFTable table, Object data) {
        if (null == data) return;
        DetailData detailData = (DetailData) data;

//        List<RowRenderData> labors = detailData.getLabors();
//        if (null != labors) {
//            table.removeRow(laborsStartRow);
//            // 循环插入行
//            for (int i = 0; i < labors.size(); i++) {
//                XWPFTableRow insertNewTableRow = table.insertNewTableRow(laborsStartRow);
//                for (int j = 0; j < 4; j++) insertNewTableRow.createCell();
//
//                // 合并单元格
//                TableTools.mergeCellsHorizonal(table, laborsStartRow, 0, 3);
//                MiniTableRenderPolicy.Helper.renderRow(table, laborsStartRow, labors.get(i));
//            }
//        }

        List<RowRenderData> goods = detailData.getGoods();
        if (null != goods) {
            table.removeRow(goodsStartRow);
            for (int i = 0; i < goods.size(); i++) {
                XWPFTableRow insertNewTableRow = table.insertNewTableRow(goodsStartRow);
//                CTTrPr trPr = insertNewTableRow.getCtRow().addNewTrPr();
//                CTHeight ht = trPr.addNewTrHeight();
//                ht.setVal(BigInteger.valueOf(360));
                for (int j = 0; j < 4  ; j++) {
                    insertNewTableRow.createCell();
                }
                MiniTableRenderPolicy.Helper.renderRow(table, goodsStartRow, goods.get(i));
            }
        }
    }

}