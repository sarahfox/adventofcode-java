package com.w3foxes.sarah.Year2024.Day09;

public class Block {
    
        long id;
        int free;
        int blocks;

        public Block(long id, int free, int blocks) {
            this.id = id;
            this.free = free;
            this.blocks = blocks;
        }
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public int getFree() {
            return free;
        }
        public void setFree(int free) {
            this.free = free;
        }
        public int getBlocks() {
            return blocks;
        }
        public void setBlocks(int blocks) {
            this.blocks = blocks;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (id ^ (id >>> 32));
            result = prime * result + free;
            result = prime * result + blocks;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Block other = (Block) obj;
            if (id != other.id)
                return false;
            if (free != other.free)
                return false;
            if (blocks != other.blocks)
                return false;
            return true;
        }
}
