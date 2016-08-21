package com.example.listview;

import java.io.File;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		// TODO �Զ����ɵķ������
		super.onCreate();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				this)
				// max width, max height���������ÿ�������ļ�����󳤿�
				.memoryCacheExtraOptions(480, 800)
				// Can slow ImageLoader, use it carefully (Better don't use
				// it)���û������ϸ��Ϣ����ò�Ҫ�������
				.discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75, null)
				// �̳߳��ڼ��ص�����
				.threadPoolSize(3)
				// �߳����ȼ�
				.threadPriority(Thread.NORM_PRIORITY - 2)
				/*
				 * When you display an image in a small ImageView and later you
				 * try to display this image (from identical URI) in a larger
				 * ImageView so decoded image of bigger size will be cached in
				 * memory as a previous decoded image of smaller size. So the
				 * default behavior is to allow to cache multiple sizes of one
				 * image in memory. You can deny it by calling this method: so
				 * when some image will be cached in memory then previous cached
				 * size of this image (if it exists) will be removed from memory
				 * cache before.
				 */
				.denyCacheImageMultipleSizesInMemory()

				// You can pass your own memory cache
				// implementation�����ͨ���Լ����ڴ滺��ʵ��
				// .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 *
				// 1024))
				// .memoryCacheSize(2 * 1024 * 1024)
				// Ӳ�̻���50MB
				.discCacheSize(50 * 1024 * 1024)
				// �������ʱ���URI������MD5
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				// ����
				.discCacheFileNameGenerator(new HashCodeFileNameGenerator())
				// �������ʱ���URI������HASHCODE����
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.discCacheFileCount(100)
				// �����File����
				.discCache(
						new UnlimitedDiscCache(new File(Environment
								.getExternalStorageDirectory()
								+ "myApp/imageCache")))
				// �Զ��建��·��
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
				.imageDownloader(
						new BaseImageDownloader(this, 5 * 1000, 30 * 1000)) // connectTimeout
				.writeDebugLogs() // Remove for release app
				.build();
		ImageLoader.getInstance().init(config);// ȫ�ֳ�ʼ��������  
		
	}

	public DisplayImageOptions getDisplayOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
		// ����ͼƬ�������ڼ���ʾ��ͼƬ
				.showImageOnLoading(R.drawable.ic_launcher)
				// ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
				.showImageForEmptyUri(R.drawable.ic_launcher)
				// ����ͼƬ����/��������д���ʱ����ʾ��ͼƬ
				.showImageOnFail(R.drawable.ic_launcher)
				// �������ص�ͼƬ�Ƿ񻺴����ڴ���
				.cacheInMemory(true)
				// �������ص�ͼƬ�Ƿ񻺴���SD����
				.cacheOnDisc(true)
				// ����Exif��Ϣ
				.considerExifParams(true)
				// ����ͼƬ����εı��뷽ʽ��ʾ
				.imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
				// ����ͼƬ�Ľ�������
				.bitmapConfig(Bitmap.Config.RGB_565)
				// .decodingOptions(android.graphics.BitmapFactory.Options
				// decodingOptions)//����ͼƬ�Ľ�������
				// .considerExifParams(true)
				// ����ͼƬ����ǰ���ӳ�
				// .delayBeforeLoading(100)// int
				// delayInMillisΪ�����õ��ӳ�ʱ��
				// ����ͼƬ���뻺��ǰ����bitmap��������
				// .preProcessor(BitmapProcessor preProcessor)
				.resetViewBeforeLoading(true)// ����ͼƬ������ǰ�Ƿ����ã���λ
				.displayer(new RoundedBitmapDisplayer(20))// �Ƿ�����ΪԲ�ǣ�����Ϊ����
				.displayer(new FadeInBitmapDisplayer(100))// ����
				.build();
		return options;
	}
}
