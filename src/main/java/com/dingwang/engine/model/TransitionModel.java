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

import com.dingwang.engine.Action;

/**
 * 变迁定义transition元素
 * 
 * @author yuqs
 * @since 1.0
 */
public class TransitionModel extends BaseModel implements Action {

    /**
     * 
     */
    private static final long serialVersionUID = 3688123410411321158L;
    /**
     * 变迁的源节点引用
     */
    private NodeModel         source;
    /**
     * 变迁的目标节点引用
     */
    private NodeModel         target;
    /**
     * 变迁的目标节点name名称
     */
    private String            to;
    /**
     * 变迁的条件表达式，用于decision
     */
    private String            expr;
    /**
     * 转折点图形数据
     */
    private String            g;

    public NodeModel getSource() {
        return source;
    }

    public void setSource(NodeModel source) {
        this.source = source;
    }

    public NodeModel getTarget() {
        return target;
    }

    public void setTarget(NodeModel target) {
        this.target = target;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    /*
     * (non-Javadoc)
     * @see com.dingwang.engine.Action#execute()
     */
    @Override
    public void execute() {
        // TODO Auto-generated method stub

    }
}
