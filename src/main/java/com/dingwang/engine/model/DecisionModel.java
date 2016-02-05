/* Copyright 2013-2015 www.snakerflow.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dingwang.engine.model;

import java.beans.Expression;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 决策定义decision元素
 * 
 * @author yuqs
 * @since 1.0
 */
public class DecisionModel extends NodeModel {
    private static final Logger  log              = LoggerFactory.getLogger(DecisionModel.class);
    /**
     * 
     */
    private static final long    serialVersionUID = -806621814645169999L;
    /**
     * 决策选择表达式串（需要表达式引擎解析）
     */
    private String               expr;
    /**
     * 表达式解析器
     */
    private transient Expression expression;

    /*
     * (non-Javadoc)
     * @see com.dingwang.engine.Action#execute(com.dingwang.engine.Execution)
     */
    @Override
    public void execute() {
        // TODO Auto-generated method stub

    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

}
