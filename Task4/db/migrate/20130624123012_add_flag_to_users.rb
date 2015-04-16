class AddFlagToUsers < ActiveRecord::Migration
  def change
    add_column :users, :flag, :integer
    add_index :users, :flag, :unique => false
  end
end
